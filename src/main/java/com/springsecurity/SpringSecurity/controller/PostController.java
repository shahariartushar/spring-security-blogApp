package com.springsecurity.SpringSecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.SpringSecurity.payload.PostDTO;
import com.springsecurity.SpringSecurity.service.PostService;

@RestController
@RequestMapping("api/posts")
public class PostController {
	
	private PostService postService;
	
	@Autowired
	public PostController(PostService postService) {
		super();
		this.postService = postService;
	}
	
	// Create blog post
	@PostMapping
	public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO){
		
		return new ResponseEntity<>(postService.createPost(postDTO), HttpStatus.CREATED);
	}
	
	// Get all blog post
	@GetMapping
	public List<PostDTO> getAllPosts(){
		
		return postService.getAllPosts();
	}
	
	
}
