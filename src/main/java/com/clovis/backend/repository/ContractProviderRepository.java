package com.clovis.backend.repository;


import com.clovis.backend.model.ContractProvider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractProviderRepository extends CrudRepository<ContractProvider, Long> {
}
