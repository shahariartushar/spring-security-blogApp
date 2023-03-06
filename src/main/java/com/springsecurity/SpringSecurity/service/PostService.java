package com.springsecurity.SpringSecurity.service;

import java.util.List;

import com.springsecurity.SpringSecurity.payload.PostDTO;
import com.springsecurity.SpringSecurity.payload.PostResponse;

public interface PostService {
	PostDTO createPost(PostDTO postDTO);
	PostResponse getAllPosts(int pageNo, int pageSize);
	PostDTO getPostById(String id);
	PostDTO updatePost(PostDTO postDTO, String id);

	void deletePost(String id);

}
