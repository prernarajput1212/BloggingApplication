package com.Blogging.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@Entity
@NoArgsConstructor
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer categoryId;
	@Column(name="Title", nullable=false)
	private String categoryTitle;
	@Column(name="Description", length=100,nullable=false)
	private String categoryDescription;

	
	@OneToMany(mappedBy="category",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Post> posts=new ArrayList<>();
	
}
