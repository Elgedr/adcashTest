package com.example.ellina.project.controllers;

import com.example.ellina.project.entity.ProductEntity;
import com.example.ellina.project.exceptions.ProductNotFoundException;
import com.example.ellina.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity getAllProducts() {
        try {
            return ResponseEntity.ok(productService.getAllProducts());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error Occurred");
        }
    }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody ProductEntity product, @RequestParam Long categoryId) {
        try {
            return ResponseEntity.ok(productService.creating(product, categoryId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error occurred");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getProductById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(productService.getById(id));
        } catch (ProductNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error occurred");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(productService.deleteProduct(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error occurred");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity UpdateProductName(@PathVariable Long id, @RequestParam String name) {
        try {
            return ResponseEntity.ok(productService.updateProduct(id, name));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error occurred");
        }
    }

    @GetMapping("/category/{category}")
    public ResponseEntity getProductsByCategory(@PathVariable String category) {
        try {
            return ResponseEntity.ok(productService.getProductsByCategory(category));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error occurred");
        }
    }
}
