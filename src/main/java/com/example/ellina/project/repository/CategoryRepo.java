package com.example.ellina.project.repository;

import com.example.ellina.project.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<CategoryEntity, Long> {
}
