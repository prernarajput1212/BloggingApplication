package com.Blogging.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Blogging.Entity.Post;
import com.Blogging.Payloads.ApiResponse;
import com.Blogging.Payloads.PageResponse;
import com.Blogging.Payloads.PostDto;
import com.Blogging.services.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {
	
	@Autowired
	private PostService postService;
	//create post
	@PostMapping("/User/{userId}/Category/{categoryId}/Posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,
			                                   @PathVariable Integer userId,
			 									@PathVariable Integer categoryId
			 									){
PostDto createdPost	=	this.postService.createPost(postDto,userId, categoryId);

		return new ResponseEntity<PostDto>(createdPost,HttpStatus.CREATED);
	}
	
	//get posts by categories
	@GetMapping("/Category/{categoryId}/Posts")
	public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId){
	List<PostDto>posts=this.postService.getAllByCategory(categoryId);
return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
	}

 

//get posts by User
	@GetMapping("/User/{userId}/Posts")
	public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId){
	List<PostDto>posts=this.postService.getAllByUser(userId);
return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
	}
	
	//get All posts
	@GetMapping("/Allposts")
	public ResponseEntity<PageResponse> getAllPosts(@RequestParam(value="pageNumber",defaultValue="0",required=false) Integer pageNumber,
			@RequestParam(value="pageSize",defaultValue="10",required=false) Integer pageSize,
			@RequestParam(value="sortBy",defaultValue="postId",required=false)String sortBy,
	@RequestParam(value="sortDir",defaultValue="asc",required=false) String sortDir)
	{
	PageResponse postResponse= this.postService.getAllPost(pageNumber,pageSize,sortBy,sortDir);
	return new ResponseEntity<PageResponse>(postResponse,HttpStatus.OK);
	}
	
	//get post by Id
	@GetMapping("/post/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
PostDto post= this.postService.getById(postId);
	return new ResponseEntity<PostDto>(post,HttpStatus.OK);
	}
	
	//Delete the post
	@DeleteMapping("/Delete/{postId}")
	public ApiResponse deletePost(@PathVariable Integer postId) {
		this.postService.deletePost(postId);
		return new ApiResponse("Post is successfully Deleted", true);
	}
	
	//Update the post
		@PutMapping("/Update/{postId}")
		public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Integer postId) {
		PostDto updatedPost=	this.postService.updatePost(postDto, postId);
			return new ResponseEntity<PostDto>(updatedPost,HttpStatus.OK);
		}
		
		// Search by keyword
		@GetMapping("/search/{keyword}")
		public ResponseEntity<List<PostDto>> postSearchByKeyword(@PathVariable("keyword") String keyword){
			List<PostDto> result=this.postService.searchByKeyword(keyword);
			return new ResponseEntity<List<PostDto>>(result, HttpStatus.OK);
		}
		
}
