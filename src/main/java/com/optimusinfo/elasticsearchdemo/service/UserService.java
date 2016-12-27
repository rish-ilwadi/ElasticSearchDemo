package com.optimusinfo.elasticsearchdemo.service;

import java.util.List;

import com.optimusinfo.elasticsearchdemo.domain.User;


public interface UserService {
	List<User> findByNameOrEmail(String searchParam);
	
	User saveUser(User user);
}
