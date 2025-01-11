package com.Blogging.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Posts")
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer postId;
	
@Column(length=100,nullable=false)
	private String postTitle;
@Column(length=1000)
	private String postContent;
	private String imageName;
	private Date postDate;
	
	@ManyToOne
	@JoinColumn(name="categoryId")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;

}
