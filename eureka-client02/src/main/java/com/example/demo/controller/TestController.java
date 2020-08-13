package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/hello")
	public String hello(){
		return "hello";
	}

	@GetMapping("/hello2")
	public String hello2(){
		return "hello";
	}
}
