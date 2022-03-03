package com.example.ellina.project.models;

import com.example.ellina.project.entity.CategoryEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Category {
    private Long id;
    private String categoryName;
    private List<Product> products;

    public Category() {

    }

    public static Category toModel(CategoryEntity entity) {
        Category category = new Category();
        category.setId(entity.getId());
        category.setCategoryName(entity.getCategoryName());
        if (entity.getProductEntities() == null) {
            List<Product> products = new ArrayList<>();
            category.setProducts(products);
        } else {
            category.setProducts(entity.getProductEntities().stream().map(Product::toModel).collect(Collectors.toList()));
        }

        return category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
