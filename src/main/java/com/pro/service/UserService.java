package com.pro.service;

import java.util.List;

import com.pro.entity.User;



public interface UserService {
	
	 public long save(User user );
	   
	 public void update(long mobileNo, User user);
	 
	public void delete(long mobileNo);
	 
	 public User getUser(long mobileNo);
	   
	   public List<User> getAllUsers();

	
	   
	   

}
