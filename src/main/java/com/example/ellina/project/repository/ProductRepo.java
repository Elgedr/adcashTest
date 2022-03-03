package com.example.ellina.project.repository;

import com.example.ellina.project.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<ProductEntity, Long> {

}
