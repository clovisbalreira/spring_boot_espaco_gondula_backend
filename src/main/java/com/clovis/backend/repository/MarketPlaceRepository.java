package com.clovis.backend.repository;

import com.clovis.backend.model.MarketPlace;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketPlaceRepository extends CrudRepository<MarketPlace, Long> {
}
