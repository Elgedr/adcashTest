package com.example.ellina.project.controllers;

import com.example.ellina.project.entity.PostEntity;
import com.example.ellina.project.exceptions.PostAlreadyExistsException;
import com.example.ellina.project.exceptions.PostNotFoundException;
import com.example.ellina.project.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity getPosts() {
        try {
            return ResponseEntity.ok(postService.getAllPosts());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error Occurred");
        }
    }

    @PostMapping
    public ResponseEntity makePost(@RequestBody PostEntity post, @RequestParam Long categoryId) {
        try {
            postService.creating(post, categoryId);
            return ResponseEntity.ok("Post was successfully saved");
        } catch (PostAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error occurred");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getPostById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(postService.getById(id));
        } catch (PostNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error occurred");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePost(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(postService.deletePost(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error occurred");
        }
    }
}
