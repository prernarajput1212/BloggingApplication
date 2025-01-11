package com.Blogging.services.Impl;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.Blogging.Entity.Category;
import com.Blogging.Entity.Post;
import com.Blogging.Entity.User;
import com.Blogging.Exceptions.ResourceNotFoundException;
import com.Blogging.Payloads.PageResponse;
import com.Blogging.Payloads.PostDto;
import com.Blogging.Respositories.CategoryRepo;
import com.Blogging.Respositories.PostsRepo;
import com.Blogging.Respositories.UserRepo;
import com.Blogging.services.PostService;
@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private PostsRepo postsRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private UserRepo userRepo;
	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
		User user =	this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "User Id", userId));
		Category category =this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "Category Id", categoryId));
		
				Post post=	 this.modelMapper.map(postDto, Post.class);
			 post.setImageName("default.png");
			 post.setPostDate(new Date());
			 post.setCategory(category);
			 post.setUser(user);
		Post newPost	= this.postsRepo.save(post);
					return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post pos=this.postsRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "Post Id",postId));
		pos.setPostContent(postDto.getPostContent());
		pos.setPostTitle(postDto.getPostTitle());
		pos.setImageName(postDto.getImageName());
		Post updatedPost=this.postsRepo.save(pos);
		return this.modelMapper.map(updatedPost,PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
		Post pos=this.postsRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","post Id",postId));
	this.postsRepo.delete(pos);
		
	}

	@Override
	public PageResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir) {
		Sort sort=(sortDir.equalsIgnoreCase("asc"))?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
		
		PageRequest p=PageRequest.of(pageNumber, pageSize, sort);
		
		Page <Post> pagePost=this.postsRepo.findAll(p);
		List<Post> posts=pagePost.getContent();
		
		List<PostDto> postDtos=posts.stream().map((post)->this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
		PageResponse pageResponse=new PageResponse();
	pageResponse.setContent(postDtos);
		pageResponse.setPageNumber(pagePost.getNumber());
		pageResponse.setPageSize(pagePost.getSize());
		pageResponse.setTotalElement(pagePost.getTotalElements());
		pageResponse.setLastPage(pagePost.isLast());
		
		return pageResponse;
	}

	@Override
	public PostDto getById(Integer postId) {
	Post post=	this.postsRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "Post Id",postId));
		return this.modelMapper.map(post,PostDto.class);
	
	}

	@Override
	public List<PostDto> getAllByCategory(Integer categoryId) {
		Optional<Category> cat= this.categoryRepo.findById(categoryId);
	List<Post>posts=	this.postsRepo.findByCategory(cat);
	List<PostDto>postDtos=posts.stream().map((post)->this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<PostDto> getAllByUser(Integer userId) {
		 Optional<User> user1 = this.userRepo.findById(userId);
		List<Post> posts=this.postsRepo.findByUser(user1);
		List<PostDto>postDtos=posts.stream().map((post)->this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
		return postDtos;
	
	}

	@Override
	public List<PostDto> searchByKeyword(String keyword) {
		List<Post>posts=this.postsRepo.findByPostTitleContaining(keyword);
		List<PostDto> postDtos=posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
		
	}

	
}
