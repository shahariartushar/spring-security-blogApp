package com.springsecurity.SpringSecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	// Get a blog post by id
	@GetMapping("/{id}")
	public ResponseEntity<PostDTO> getPostById(@PathVariable String id){
		return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
		//return ResponseEntity.ok(postService.getPostById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDTO, @PathVariable String id){
		return new ResponseEntity<>(postService.updatePost(postDTO, id), HttpStatus.OK);
		//return ResponseEntity.ok(postService.updatePost(postDTO, id));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePost(@PathVariable String id){
		postService.deletePost(id);

		return new ResponseEntity<>("Post has been deleted with id: " + id, HttpStatus.OK);
	}
	
	
}
