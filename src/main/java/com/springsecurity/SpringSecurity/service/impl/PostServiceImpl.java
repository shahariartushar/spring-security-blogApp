package com.springsecurity.SpringSecurity.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.springsecurity.SpringSecurity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecurity.SpringSecurity.Mapper.PostMapper;
import com.springsecurity.SpringSecurity.model.Post;
import com.springsecurity.SpringSecurity.payload.PostDTO;
import com.springsecurity.SpringSecurity.repository.PostRepository;
import com.springsecurity.SpringSecurity.service.PostService;



@Service
public class PostServiceImpl implements PostService{
	
	private PostRepository postRepository;
	
	
	@Autowired
	public PostServiceImpl(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@Override
	public PostDTO createPost(PostDTO postDTO) {
		// Convert DTO to model
		Post post = PostMapper.mapToModel(postDTO);
		
		Post newPost = postRepository.save(post);
		
		// Convert entity to DTO
		PostDTO postResponseDto = PostMapper.mapToDTO(newPost);
		
		return postResponseDto;
	}

	@Override
	public java.util.List<PostDTO> getAllPosts() {
		List<Post> posts = postRepository.findAll();
		
		return posts.stream().map(post -> PostMapper.mapToDTO(post)).collect(Collectors.toList());

	}

	@Override
	public PostDTO getPostById(String id) {
		Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
		return PostMapper.mapToDTO(post);
	}

	@Override
	public PostDTO updatePost(PostDTO postDTO, String id) {
		Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

		post.setTitle(postDTO.getTitle());
		post.setDesc(postDTO.getDesc());
		post.setContent(postDTO.getContent());

		return PostMapper.mapToDTO(post);
	}

	@Override
	public void deletePost(String id) {
		Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
		postRepository.delete(post);
	}
}
