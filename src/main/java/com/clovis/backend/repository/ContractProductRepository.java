package com.clovis.backend.repository;

import com.clovis.backend.model.ContractProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractProductRepository extends CrudRepository<ContractProduct, Long> {
}
