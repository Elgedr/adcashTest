package com.example.ellina.project.service;

import com.example.ellina.project.entity.CategoryEntity;
import com.example.ellina.project.entity.ProductEntity;
import com.example.ellina.project.exceptions.ProductNotFoundException;
import com.example.ellina.project.models.Product;
import com.example.ellina.project.repository.CategoryRepo;
import com.example.ellina.project.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    public Product creating(ProductEntity product, Long categoryId) {
        CategoryEntity category = categoryRepo.findById(categoryId).get();
        product.setCategory(category);
        return Product.toModel(productRepo.save(product));
    }

    public Product updateProduct(Long productId, String nameToChangeTo) {
        ProductEntity product = productRepo.findById(productId).get();
        product.setProductName(nameToChangeTo);
        return Product.toModel(productRepo.save(product));
    }

    public Product getById(Long id) throws ProductNotFoundException {
        ProductEntity product = productRepo.findById(id).get();
        if (product == null) {
                throw new ProductNotFoundException("Product not found.");
        }
        return Product.toModel(product);
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        Iterable<ProductEntity> result = productRepo.findAll();
        for (ProductEntity product1 : result) {
            products.add(Product.toModel(product1));
        }
        return products;
    }

    public Long deleteProduct(Long id) {
        productRepo.deleteById(id);
        return id;
    }

    public List<Product> getProductsByCategory(String category) {
        List<Product> products = new ArrayList<>();
        Iterable<ProductEntity> result = productRepo.findAll();
        for (ProductEntity product1 : result) {
            if (Objects.equals(product1.getCategory().getCategoryName(), category)) {
                products.add(Product.toModel(product1));
            }
        }
        return products;
    }
}


