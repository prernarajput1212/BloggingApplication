package com.Blogging.Payloads;

import java.util.Date;

import com.Blogging.Entity.Category;
import com.Blogging.Entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class PostDto {

	private String postContent;
	private Integer postId;
	private String postTitle;
	private String imageName;
	private Date postDate;
	private CategoryDto category;
	private UserDto user;

}
