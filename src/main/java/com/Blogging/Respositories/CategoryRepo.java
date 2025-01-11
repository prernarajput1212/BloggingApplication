package com.Blogging.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Blogging.Entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
