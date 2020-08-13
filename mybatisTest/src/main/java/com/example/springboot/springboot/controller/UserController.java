package com.example.springboot.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	@RequestMapping("/index")
	public String index(){
		return "index";
	}

	@GetMapping("/test")
	public String test(){
		return "index";
	}
}
