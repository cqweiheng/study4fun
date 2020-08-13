package com.example.mybatis02.mybatis.controller;

import com.example.mybatis02.mybatis.enumeration.SexEnum;
import com.example.mybatis02.mybatis.pojo.User;
import com.example.mybatis02.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@ResponseBody
	@GetMapping("/user/{id}")
//	@Cacheable(value="short_cache", key = "'redis_user_'+ #id")
	public User getUserById(@PathVariable Long id){
			return userService.getUser(id);
	}

	@ResponseBody
	@GetMapping("/user2/{id}")
	@Cacheable(value="long_cache", key = "'redis_user_'+#id")
	public User getUserById2(@PathVariable Long id){
		return userService.getUser(id);
	}

	@ResponseBody
	@PatchMapping("/user/{id}")
	public String updateUserName(@PathVariable Long id, String name){
		boolean flag = userService.updateUserName(id, name);
		return flag ? "success" : "false";
	}

	@ResponseBody
	@PostMapping("/insertUser")
	public Map insertUser(String name, int sex, String note){
		User user = new User();
		user.setUserName(name);
		user.setSex(SexEnum.getEnumById(sex));
		user.setNote(note);
		int i = userService.insertUser(user);
		return new HashMap(){{put("success", i > 0 ? "true" : "false"); put("user", user);}};
	}
}
