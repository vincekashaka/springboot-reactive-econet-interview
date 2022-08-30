package com.vince.reactive.econet.dto;

import com.vince.reactive.econet.model.Shop;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import reactor.core.publisher.Flux;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AreaDto {

    private String areaId;
    private String areaName;
    private Flux<Shop> shopFlux;
}
