package com.blog.service;

import java.util.Optional;

import com.blog.model.User;
//import com.blog.repository.RoleRepository;
import com.blog.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService   {

	private UserRepository userRepository;
	//private RoleRepository roleRepository;
	
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
		//this.roleRepository = roleRepository;
	}
	

	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public User fetchUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public User fetchUserByEmailAndPassword(String email,String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}

	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}	
	
}
