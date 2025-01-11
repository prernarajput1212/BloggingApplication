package com.Blogging.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Blogging.Payloads.CategoryDto;

public interface CategoryService  {
	//create
	 CategoryDto createCategory(CategoryDto CategoryDto);
	
	//update
 CategoryDto updateCategory(CategoryDto CategoryDto, Integer categoryId);
	
	//get by id
 CategoryDto getCategory(Integer categoryId);
 
	//get all
  List<CategoryDto> getAllCategory();
  
  
	//delete
  void deleteCategory(Integer categoryId);

}
