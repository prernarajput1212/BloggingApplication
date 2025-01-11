package com.Blogging.controllers;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import com.Blogging.Payloads.ApiResponse;
import com.Blogging.Payloads.CategoryDto;
import com.Blogging.services.CategoryService;

import net.bytebuddy.asm.Advice.Return;

@RestController
@RequestMapping("/api/Categories")
public class CategoriesController {
	
	@Autowired
	private CategoryService CategoryService;
	@PostMapping("/create")
         public	ResponseEntity<CategoryDto> createCategory(@Valid@RequestBody CategoryDto CategoryDto){
		CategoryDto CreatecategoryDto= this.CategoryService.createCategory(CategoryDto);
		return new ResponseEntity<>(CreatecategoryDto, HttpStatus.CREATED);
	}
	//update
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid@RequestBody CategoryDto CategoryDto,@PathVariable Integer categoryId){
		CategoryDto UpdatecategoryDto= this.CategoryService.updateCategory(CategoryDto, categoryId);
		return new ResponseEntity<CategoryDto>(UpdatecategoryDto,HttpStatus.OK);
	}
	
	//delete
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
		this.CategoryService.deleteCategory(categoryId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category Deleted successfully",false),HttpStatus.OK);
		
	}
	//get single
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer categoryId){
		CategoryDto getCategoryDto= this.CategoryService.getCategory(categoryId);
		return new ResponseEntity<CategoryDto>(getCategoryDto, HttpStatus.OK);
	}
	//getall
@GetMapping("/AllCategories")
public ResponseEntity <List<CategoryDto>> getAllCategory(){
	return ResponseEntity.ok(this.CategoryService.getAllCategory()) ;
}
}
