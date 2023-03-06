package com.springsecurity.SpringSecurity.model;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Document(value = "posts")
public class Post {
	@Id
	private String id;
	@Indexed(unique = true)
	@NotNull(message = "title cannot be null")
	private String title;
	@NotNull(message = "desc cannot be null")
	private String desc;
	@NotEmpty
	@NotNull(message = "content cannot be null")
	private String content;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
