package com.springsecurity.SpringSecurity.Mapper;

import com.springsecurity.SpringSecurity.model.Post;
import com.springsecurity.SpringSecurity.payload.PostDTO;
import org.springframework.beans.factory.annotation.Autowired;


public class PostMapper {

	public static Post mapToModel(PostDTO postDTO) {
		//Post post = modelMapper.map(postDTO, Post.class);

		Post post = new Post();
		post.setTitle(postDTO.getTitle());
		post.setDesc(postDTO.getDesc());
		post.setContent(postDTO.getContent());
		
		return post;
	}
	
	public static PostDTO mapToDTO(Post post) {
		//PostDTO postResponseDto = modelMapper.map(post, PostDTO.class);

		PostDTO postResponseDto = new PostDTO();
		postResponseDto.setId(post.getId());
		postResponseDto.setTitle(post.getTitle());
		postResponseDto.setDesc(post.getDesc());
		postResponseDto.setContent(post.getContent());
		
		return postResponseDto;
	}
}
