package com.springsecurity.SpringSecurity.Mapper;

import com.springsecurity.SpringSecurity.model.Post;
import com.springsecurity.SpringSecurity.payload.PostDTO;


public class PostMapper {
	public static Post mapToModel(PostDTO postDTO) {
		Post post = new Post();
		post.setTitle(postDTO.getTitle());
		post.setDesc(postDTO.getDesc());
		post.setContent(postDTO.getContent());
		
		return post;
	}
	
	public static PostDTO mapToDTO(Post post) {
		PostDTO postResponseDto = new PostDTO();
		postResponseDto.setId(post.getId());
		postResponseDto.setTitle(post.getTitle());
		postResponseDto.setDesc(post.getDesc());
		postResponseDto.setContent(post.getContent());
		
		return postResponseDto;
	}
}
