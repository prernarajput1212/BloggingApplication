package com.Blogging.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Blogging.Entity.Category;
import com.Blogging.Exceptions.ResourceNotFoundException;
import com.Blogging.Payloads.CategoryDto;
import com.Blogging.Respositories.CategoryRepo;
import com.Blogging.services.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class CategoryImpl implements CategoryService {
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper ModelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto CategoryDto) {
		Category map=this.ModelMapper.map(CategoryDto,Category.class);//return Category class ka object
		Category addedcat=this.categoryRepo.save(map);
	
		return this.ModelMapper.map(addedcat,CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto CategoryDto, Integer categoryId) {
		Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "CategoryId", categoryId));
		cat.setCategoryTitle(CategoryDto.getCategoryTitle());
		cat.setCategoryDescription(CategoryDto.getCategoryDescription());
		Category updatecat=this.categoryRepo.save(cat);
		return this.ModelMapper.map(updatecat,CategoryDto.class);
	
		
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "CategoryId", categoryId));
	return this.ModelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
	List<Category> categories=this.categoryRepo.findAll();
	
		List<CategoryDto> dtos= categories.stream().map((cat)->this.ModelMapper.map(cat,CategoryDto.class)).collect(Collectors.toList());
	return dtos;
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "CategoryId", categoryId));
		this.categoryRepo.delete(cat);
		
	}

}
