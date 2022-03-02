package com.example.ellina.project.controllers;

import com.example.ellina.project.entity.CategoryEntity;
import com.example.ellina.project.exceptions.CategoryNotFound;
import com.example.ellina.project.service.CategoryService;
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
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity createCategory(@RequestBody CategoryEntity category) {
        try {
            return ResponseEntity.ok(categoryService.createCategory(category));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error occurred");
        }

    }

    @PutMapping
    public ResponseEntity updateCategoryName(@PathVariable Long id, @RequestParam String name) {
        try {
            return ResponseEntity.ok(categoryService.updateCategory(id, name));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error occurred");
        }

    }

    @GetMapping
    public ResponseEntity getCategories() {
        try {
            return ResponseEntity.ok(categoryService.getAllCategories());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error Occurred");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getCategoryById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(categoryService.getById(id));
        } catch (CategoryNotFound e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error occurred");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategory(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(categoryService.deletePost(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error occurred");
        }
    }
}
