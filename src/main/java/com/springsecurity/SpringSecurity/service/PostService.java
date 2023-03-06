package com.springsecurity.SpringSecurity.service;

import java.util.List;

import com.springsecurity.SpringSecurity.payload.PostDTO;

public interface PostService {
	PostDTO createPost(PostDTO postDTO);
	List<PostDTO> getAllPosts();
	PostDTO getPostById(String id);
	PostDTO updatePost(PostDTO postDTO, String id);

	void deletePost(String id);

}
