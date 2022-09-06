package com.vince.reactive.econet.controller;


import com.vince.reactive.econet.dto.AreaDto;
import com.vince.reactive.econet.model.Area;
import com.vince.reactive.econet.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Mono<AreaDto>> getAreaById(@PathVariable("areaId") String areaId){
        Mono<AreaDto> areaDtoMono = areaService.getAreaById(areaId);
        HttpStatus status = (areaDtoMono != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(areaDtoMono, status);
    }


    @PostMapping
   @ResponseStatus(HttpStatus.CREATED)
    public Mono<AreaDto> saveArea(@Valid @RequestBody Mono<AreaDto> areaDtoMono){
        return   areaService.saveArea(areaDtoMono);
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
