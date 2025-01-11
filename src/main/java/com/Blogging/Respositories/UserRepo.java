package com.Blogging.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Blogging.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
