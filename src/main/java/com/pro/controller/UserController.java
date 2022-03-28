package com.pro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pro.entity.User;
import com.pro.service.UserService;


@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("/user")
	public ResponseEntity<?> save(@RequestBody User user){
		long mobileNo = userService.save(user);
		return ResponseEntity.ok("USer record saved successfully with : "+mobileNo);
	}
	
	@PutMapping("/user/{mobileNo}")
	public ResponseEntity<?> update(@PathVariable("mobileNo") long mobileNo, @RequestBody User user)
	{
		userService.update(mobileNo, user);
		
		return ResponseEntity.ok("User record updated successfully");
	}
	
	@DeleteMapping("/user/{mobileNo}")
	public ResponseEntity<?> delete(@PathVariable("mobileNo") long mobileNo)
	{
		userService.delete(mobileNo);
		
		return ResponseEntity.ok().body("Record deleted successfully");
	}
	
	@GetMapping("/user/{mobileNo}")
	public ResponseEntity<User> getUserBymobileNo(@PathVariable("mobileNo") long mobileNo)
	{
		
		User u =  userService.getUser(mobileNo);
		
		return ResponseEntity.ok().body(u);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers()
	{
		
		List<User> emplist =  userService.getAllUsers();
		
		return ResponseEntity.ok().body(emplist);
	}

}
