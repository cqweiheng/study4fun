package com.example.mybatis02.mybatis.controller;

import com.example.mybatis02.mybatis.enumeration.SexEnum;
import com.example.mybatis02.mybatis.interceptors.TokenInterceptor;
import com.example.mybatis02.mybatis.pojo.User;
import com.example.mybatis02.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Controller
public class TestController {

	@Autowired
	private UserService userService;

	@RequestMapping("/index")
	public String index(){
		return "index";
	}

	@GetMapping("/restTest/{id}")
	@ResponseBody
	public User user(@PathVariable Long id){
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(new TokenInterceptor());
		ResponseEntity<User> forEntity = restTemplate.getForEntity("http://127.0.0.1:8080/user/{id}", User.class, id);
		System.out.println("==================");
		if(Objects.equals(forEntity.getStatusCode(), HttpStatus.OK)){
			return forEntity.getBody();
		}
		return null;
	}

	@ResponseBody
	@GetMapping("/test/{id}")
	public User getUserById(@PathVariable Long id){
		User user = userService.getUser(id);
		return new User("妮妮", "12312s0", SexEnum.FEMALE);
	}

	@GetMapping("/csrf")
	public String testCsrf(){
		return "csrf_form";
	}

	@PostMapping("/commit")
	public ResponseEntity<String> testSubmit(){
		return new ResponseEntity<>("success", new HttpHeaders(), HttpStatus.OK);
	}
}
