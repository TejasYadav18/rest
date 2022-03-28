package com.pro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pro.dao.UserDao;
import com.pro.entity.User;

public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	
	public long save(User user) {
		return userDao.save(user);
	}

	public void update(long mobileNo, User user) {
		 userDao.update(mobileNo, user);
		
	}

	public void delete(long mobileNo) {
		userDao.delete(mobileNo);
		
	}

	

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public User getUser(long mobileNo) {
		return userDao.getUser(mobileNo);
	}


}
