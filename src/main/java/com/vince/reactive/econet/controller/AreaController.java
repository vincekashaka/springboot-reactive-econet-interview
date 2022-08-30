package com.vince.reactive.econet.controller;


import com.vince.reactive.econet.dto.AreaDto;
import com.vince.reactive.econet.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/econet")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping("/areas")
    public Flux<AreaDto> getAllAreas(){
        return areaService.getAllAreas();
    }
}
