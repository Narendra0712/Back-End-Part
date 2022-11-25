package com.mobigictest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobigictest.dao.UserDao;
import com.mobigictest.daoimpl.Response;
import com.mobigictest.pojo.User;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserDao daoImpl;
	
	//http://localhost:9009/user/login
	@PostMapping(value = "/login")
	public ResponseEntity<?> checkUser(@RequestBody User user) {
		
		User u = daoImpl.checkCredentials(user);
		
		if (u == null) {
			return Response.error("User not Found");
		}
		System.out.println(u);
		return Response.success(u);
		
	}
	
	//http://localhost:9009/user/addUser
	@PostMapping(value = "/addUser")
	public ResponseEntity<?> addUser(@RequestBody User user) {

		if (daoImpl.addUser(user)) {
			return Response.success(user);
		}
		else {
			return Response.error("User Addition Failed !");
		}
	}
}
