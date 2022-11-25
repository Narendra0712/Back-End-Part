package com.mobigictest.dao;

import com.mobigictest.pojo.User;

public interface UserDao {
	
	User checkCredentials(User user);

	boolean addUser(User user);
}
