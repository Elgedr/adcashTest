package com.example.ellina.project.service;

import com.example.ellina.project.entity.CategoryEntity;
import com.example.ellina.project.exceptions.CategoryNotFound;
import com.example.ellina.project.models.Category;
import com.example.ellina.project.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public Category createCategory(CategoryEntity category) {
        return Category.toModel(categoryRepo.save(category));
    }

    public Category updateCategory(Long id, String name) {
        CategoryEntity category = categoryRepo.findById(id).get();
        category.setCategoryName(name);
        return Category.toModel(categoryRepo.save(category));
    }

    public Iterable<CategoryEntity> getAllCategories() {
        return categoryRepo.findAll();
    }

    public Category getById(Long id) throws CategoryNotFound {
        CategoryEntity category = categoryRepo.findById(id).get();
        if (category == null) {
            throw new CategoryNotFound("Post not found.");
        }
        return Category.toModel(category);
    }

    public Long deletePost(Long id) {
        categoryRepo.deleteById(id);
        return id;
    }
}
