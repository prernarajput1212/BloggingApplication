package com.Blogging.services;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.PageRequest;

import com.Blogging.Entity.Post;
import com.Blogging.Payloads.PageResponse;
import com.Blogging.Payloads.PostDto;

public interface PostService {
	//craete post
	
	PostDto createPost(PostDto postDto, Integer userId,Integer categeoryId);
	
	//Update Post
	
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//delete post
	
	void deletePost(Integer postId);
	
	//Get All posts
	
	PageResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);

	//Get post by Id
	PostDto getById(Integer postId);
	
	//Get all post of category
	List<PostDto> getAllByCategory(Integer categoryId);
	
	//get All posts of User
	
	List<PostDto>getAllByUser(Integer userId); 
	
	//get all posts by search keyword
	
	List<PostDto> searchByKeyword(String keyword);


	
	
	
	

}
