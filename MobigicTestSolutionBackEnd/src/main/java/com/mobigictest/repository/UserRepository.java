package com.mobigictest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mobigictest.pojo.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("From User a Where a.username = ?1 and a.password = ?2")
	User login(String username,String password);
}
