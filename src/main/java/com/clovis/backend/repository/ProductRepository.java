package com.clovis.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.clovis.backend.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
