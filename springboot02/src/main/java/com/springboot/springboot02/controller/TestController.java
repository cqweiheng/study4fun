package com.springboot.springboot02.controller;

import com.springboot.springboot02.pojo.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/user/{id}")
	@ResponseStatus(HttpStatus.OK)
	public User user(@PathVariable Long id){
		User user = new User();
		user.setNote("111");
		user.setUserName("你好啊");
		user.setId(id);
		return user;
	}
}
