package com.example.springboot.controller;

import com.example.springboot.enumeration.SexEnum;
import com.example.springboot.pojo.User;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/print")
	public User printUser(String name, int age){
		User user = new User();
		user.setUserName("你好");
		user.setSex(SexEnum.MALE);
		userService.printUser(user);
		return user;
	}

	@GetMapping("/getUser")
	public User getUser(String id){
		User user = userService.getUser(id);
		return user;
	}
}
