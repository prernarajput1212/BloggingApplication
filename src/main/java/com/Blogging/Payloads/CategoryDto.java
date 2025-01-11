package com.Blogging.Payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.BatchSize;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CategoryDto {
	private Integer categoryId;
	@NotBlank
	@Size(min=5,message="Character should be more than 5 letters")
	private String categoryTitle;
	@NotBlank
	@Size(min=10,message="description should be more than 10 characters")
	private String categoryDescription;

}
