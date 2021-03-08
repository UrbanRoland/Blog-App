package com.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blog.model.User;
import com.blog.repository.RoleRepository;
import com.blog.repository.UserRepository;

@Service
public class UserService  implements UserDetailsService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	
	
	@Autowired
	public UserService(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}

		return new UserDetailsImpl(user);
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
	
}
