package com.vince.reactive.econet.controller;


import com.vince.reactive.econet.dto.AreaDto;
import com.vince.reactive.econet.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/econet")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping("/areas")
    public Flux<AreaDto> getAllAreas(){
        return areaService.getAllAreas();
    }

    @GetMapping("/{areaId}")
    public Mono<AreaDto> getAreaById(@PathVariable String areaId){
        return areaService.getAreaById(areaId);
    }


    @PostMapping
    public Mono<AreaDto> saveArea(
            @Valid
            @RequestBody Mono<AreaDto> areaDtoMono){
        return areaService.saveArea(areaDtoMono);
    }

    @PutMapping("/area/{areaId}")
    public Mono<AreaDto> updateArea(
            @Valid
            @RequestBody Mono<AreaDto> areaDtoMono,
            @PathVariable String areaId){
        return areaService.updateArea(areaDtoMono, areaId);
    }

    @DeleteMapping("/delete/{areaId}")
    public Mono<Void> deleteArea(@PathVariable String areaId){
        return areaService.deleteArea(areaId);
    }


}
