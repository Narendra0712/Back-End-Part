package com.mobigictest.daoimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobigictest.dao.UserDao;
import com.mobigictest.pojo.User;
import com.mobigictest.repository.UserRepository;

@Service
public class UserDaoImpl implements UserDao{

	@Autowired
	private UserRepository repository;
	
	@Override
	public User checkCredentials(User user) {
		
		try {
			User usr = repository.login(user.getUsername(),user.getPassword());
			
			if (usr != null) {
				
				if (usr.getUsername().equals(user.getUsername()) && usr.getPassword().equals(usr.getPassword())) {
					return usr;
				}
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addUser(User user) {
		try {
			Optional<User> opt = repository.findById(user.getUserid());
			
			if (opt.isPresent()) {
				return false;
			}
			else {
				repository.save(user);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}	
	}

}
