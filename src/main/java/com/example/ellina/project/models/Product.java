package com.example.ellina.project.models;

import com.example.ellina.project.entity.ProductEntity;

public class Product {
    private Long id;
    private String productName;
    private String productDescription;
    private String category;

    public Product() {

    }

    public static Product toModel(ProductEntity entity) {
        Product model = new Product();
        model.setId(entity.getId());
        model.setProductName(entity.getProductName());
        model.setProductDescription(entity.getProductDescription());
        model.setCategory(entity.getCategory().getCategoryName());
        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
