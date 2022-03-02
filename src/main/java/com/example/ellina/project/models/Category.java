package com.example.ellina.project.models;

import com.example.ellina.project.entity.CategoryEntity;

import java.util.List;
import java.util.stream.Collectors;

public class Category {
    private Long id;
    private String categoryName;
    private List<Post> posts;

    public Category() {

    }

    public static Category toModel(CategoryEntity entity) {
        Category category = new Category();
        category.setId(entity.getId());
        category.setCategoryName(entity.getCategoryName());
        category.setPosts(entity.getPostEntities().stream().map(Post::toModel).collect(Collectors.toList()));
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

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
