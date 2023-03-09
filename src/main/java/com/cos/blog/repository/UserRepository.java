package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cos.blog.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


	
}





//User findByUsernameAndPassword(String username, String password);

//@Query(value = "SELECT * FROM user WHERE username = ? AND password = ?", nativeQuery = true)
//User login(String username, String password);