package com.example.ellina.project.service;

import com.example.ellina.project.entity.CategoryEntity;
import com.example.ellina.project.exceptions.CategoryAlreadyExists;
import com.example.ellina.project.exceptions.CategoryNotFound;
import com.example.ellina.project.models.Category;
import com.example.ellina.project.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public Category createCategory(CategoryEntity category) throws CategoryAlreadyExists {
        if (categoryRepo.findByCategoryName(category.getCategoryName()) != null) {
            throw new CategoryAlreadyExists("Category already exists!");
        }
        return Category.toModel(categoryRepo.save(category));
    }

    public Category updateCategory(Long id, String name) {
        CategoryEntity category = categoryRepo.findById(id).get();
        category.setCategoryName(name);
        return Category.toModel(categoryRepo.save(category));
    }

    public List<Category> getAllCategories() {
        List<Category> products = new ArrayList<>();
        Iterable<CategoryEntity> result = categoryRepo.findAll();
        for (CategoryEntity category1 : result) {
            products.add(Category.toModel(category1));
        }
        return products;
    }

    public Category getById(Long id) throws CategoryNotFound {
        CategoryEntity category = categoryRepo.findById(id).get();
        if (category == null) {
            throw new CategoryNotFound("Category not found.");
        }
        return Category.toModel(category);
    }

    public Long deleteCategory(Long id) {
        categoryRepo.deleteById(id);
        return id;
    }
}
