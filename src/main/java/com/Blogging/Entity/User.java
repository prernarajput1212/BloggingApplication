package com.Blogging.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="Users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	@Column(name="User_name", nullable=false)
	private String name;
	@Column(name="User_Email")
	private String email;
	@Column(name="User_Password")
	private String password;
	private String about;

	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Post>posts=new ArrayList<>();
	

}
