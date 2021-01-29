package com.blog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.model.User;
import com.blog.service.UserService;

@RestController
@RequestMapping(path = "api/",produces = "application/json")
@CrossOrigin(origins = "http://localhost:4200")
public class ApiController {

	@Autowired
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("registration")
	public User registerUser(@RequestBody User user) throws Exception {
		String userEmail=user.getEmail();
		if(userEmail!=null && !"".equals(userEmail)) {
			User tempUser = userService.fetchUserByEmail(userEmail);
			if(tempUser!=null) {
				throw new Exception("user with "+ userEmail + "is already exist");
			}
		}
		User userObj=null;
		userObj=userService.saveUser(user);
		return userObj;
	}
	
	@PostMapping("login")
	public User loginUser(@RequestBody User user) throws Exception {
		String userEmail=user.getEmail();
		String userPassword=user.getPassword();
		User userObj=null;
		if(userEmail!=null && userPassword!=null) {
			userObj=userService.fetchUserByEmailAndPassword(userEmail, userPassword);
		}
		if(userObj==null) {
			throw new Exception("Bad credentials!");
		}
		return userObj;
	}
	
}
