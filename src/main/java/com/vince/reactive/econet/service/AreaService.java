package com.vince.reactive.econet.service;


import com.vince.reactive.econet.dto.AreaDto;
import com.vince.reactive.econet.repository.AreaRepo;
import com.vince.reactive.econet.utils.AreaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AreaService {

    @Autowired
    private AreaRepo areaRepo;

    public Flux<AreaDto> getAllAreas(){
        return areaRepo.findAll().map(AreaUtils::entityToDto);
    }

    public Mono<AreaDto> getAreaById(String areaId){
        return areaRepo.findById(areaId).map(AreaUtils::entityToDto);
    }

    public Mono<AreaDto>  saveArea(Mono<AreaDto> areaDtoMono){
        return areaDtoMono.map(AreaUtils::dtoToEntity)
                .flatMap(areaRepo::insert)
                .map(AreaUtils::entityToDto);
    }

    public Mono<AreaDto> updateArea(Mono<AreaDto> areaDtoMono, String areaId){
        return areaRepo.findById(areaId)
                .flatMap(area -> areaDtoMono.map(AreaUtils::dtoToEntity)
                        .doOnNext(a -> a.setAreaId(areaId)))
                .flatMap(areaRepo::save)
                .map(AreaUtils::entityToDto);
    }

    public Mono<Void> deleteArea(String areaId){
        return areaRepo.deleteById(areaId);
    }
}
