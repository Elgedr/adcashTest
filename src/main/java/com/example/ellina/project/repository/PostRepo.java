package com.example.ellina.project.repository;

import com.example.ellina.project.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

public interface PostRepo extends CrudRepository<PostEntity, Long> {

    PostEntity findByPostName(String name);
}
