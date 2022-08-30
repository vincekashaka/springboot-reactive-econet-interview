package com.vince.reactive.econet.repository;

import com.vince.reactive.econet.model.Area;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AreaRepo extends ReactiveMongoRepository<Area, String>{
}
