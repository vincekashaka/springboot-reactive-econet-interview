package com.vince.reactive.econet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.core.publisher.Flux;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Area_DB")
public class Area {
    @Id
    private String areaId;
    private String areaName;
    private Flux<Shop> shopFlux;
}
