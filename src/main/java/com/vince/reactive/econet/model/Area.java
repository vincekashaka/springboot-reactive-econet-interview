package com.vince.reactive.econet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Area_DB")
public class Area {
    @Id
    private String areaId;

    @NotNull
    @Size(min = 5, message = "Must be at least 5 characters ")
    @NotBlank(message="Area name is required")
    private String areaName;
    private List<Shop> shops = new ArrayList<>();
}
