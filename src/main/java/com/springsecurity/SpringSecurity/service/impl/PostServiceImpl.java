package com.springsecurity.SpringSecurity.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.springsecurity.SpringSecurity.exception.ResourceNotFoundException;
import com.springsecurity.SpringSecurity.payload.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	public PostResponse getAllPosts(int pageNo, int pageSize) {

		Pageable pageable = PageRequest.of(pageNo, pageSize);

		Page<Post> posts = postRepository.findAll(pageable);

		// Get content for page obj
		List<Post> postList = posts.getContent();
		
		 List<PostDTO> content = postList.stream().map(post -> PostMapper.mapToDTO(post)).collect(Collectors.toList());
		 PostResponse postResponse = new PostResponse();
		 postResponse.setContent(content);
		 postResponse.setPageNo(posts.getNumber());
		 postResponse.setPageSize(posts.getSize());
		 postResponse.setTotalPages(posts.getTotalPages());
		 postResponse.setTotalElements(posts.getTotalElements());
		 postResponse.setLast(posts.isLast());

		 return postResponse;


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
