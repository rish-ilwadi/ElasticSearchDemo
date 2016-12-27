package com.optimusinfo.elasticsearchdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optimusinfo.elasticsearchdemo.domain.User;
import com.optimusinfo.elasticsearchdemo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findByNameOrEmail(String searchParam) {	
		return userRepository.findByNameOrEmail(searchParam, searchParam);
	}

	@Override
	public User saveUser(User user) {		
		return userRepository.save(user);
	}

}
