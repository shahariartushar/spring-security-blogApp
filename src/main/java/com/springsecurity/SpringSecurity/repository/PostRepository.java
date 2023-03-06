package com.springsecurity.SpringSecurity.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springsecurity.SpringSecurity.model.Post;


public interface PostRepository extends MongoRepository<Post, String>{

}
