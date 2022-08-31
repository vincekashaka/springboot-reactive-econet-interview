package com.vince.reactive.econet.dto;

import com.vince.reactive.econet.model.Shop;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AreaDto {

    private String areaId;
    private String areaName;
    private List<Shop> shops;
}
