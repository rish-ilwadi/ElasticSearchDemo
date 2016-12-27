package com.optimusinfo.elasticsearchdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.optimusinfo.elasticsearchdemo.domain.User;
import com.optimusinfo.elasticsearchdemo.service.UserService;

@RestController
public class SearchController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET, value = "/ping")
	public String ping() {
		return "ping";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/postUser", headers="Content-Type=application/json")
	public User postUser(@RequestBody User user) {
		
		return userService.saveUser(user);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/searchUser")
	public List<User> findByNameOrEmail(@RequestParam(value = "searchParam", defaultValue = "") String searchParam) {
		return userService.findByNameOrEmail(searchParam);
	}
}
