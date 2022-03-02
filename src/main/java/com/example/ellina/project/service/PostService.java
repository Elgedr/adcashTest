package com.example.ellina.project.service;

import com.example.ellina.project.entity.CategoryEntity;
import com.example.ellina.project.entity.PostEntity;
import com.example.ellina.project.exceptions.PostAlreadyExistsException;
import com.example.ellina.project.exceptions.PostNotFoundException;
import com.example.ellina.project.models.Post;
import com.example.ellina.project.repository.CategoryRepo;
import com.example.ellina.project.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    public PostEntity creating(PostEntity post, Long categoryId) throws PostAlreadyExistsException {
        if (postRepo.findByPostName(post.getPostName()) != null) {
            throw new PostAlreadyExistsException("Post with this name already exists");
        }
        CategoryEntity category = categoryRepo.findById(categoryId).get();
        post.setCategory(category);
        return postRepo.save(post);
    }

    public Post getById(Long id) throws PostNotFoundException {
        PostEntity post = postRepo.findById(id).get();
        if (post == null) {
            throw new PostNotFoundException("Post not found.");
        }
        return Post.toModel(post);
    }

    public Iterable<PostEntity> getAllPosts() {
        return postRepo.findAll();
    }

    public Long deletePost(Long id) {
        postRepo.deleteById(id);
        return id;
    }


}


