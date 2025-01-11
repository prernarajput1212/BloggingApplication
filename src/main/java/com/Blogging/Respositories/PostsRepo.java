package com.Blogging.Respositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Blogging.Entity.Category;
import com.Blogging.Entity.Post;
import com.Blogging.Entity.User;
public interface PostsRepo extends JpaRepository<Post, Integer> {

	List<Post> findByCategory(Optional<Category> cat);

	List<Post> findByUser(Optional<User> user1);

	List<Post> findByPostTitleContaining(String keyword);

	

	

	

//	List<Post> findByCategory(Category category);
//	List<Post> findByUser(User user);
	
	
//	List<Post> FindByCategoryId(Category category);

}
