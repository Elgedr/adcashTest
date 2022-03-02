package com.example.ellina.project.models;

import com.example.ellina.project.entity.CategoryEntity;
import com.example.ellina.project.entity.PostEntity;

public class Post {
    private Long id;
    private String postName;
    private CategoryEntity category;
    private String postBody;

    public Post() {

    }

    public static Post toModel(PostEntity entity) {
        Post model = new Post();
        model.setId(entity.getId());
        model.setPostName(entity.getPostName());
        model.setPostBody(entity.getPostBody());
        model.setCategory(entity.getCategory());
        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
