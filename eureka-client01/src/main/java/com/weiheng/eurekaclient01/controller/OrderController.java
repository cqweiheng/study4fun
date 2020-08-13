package com.weiheng.eurekaclient01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.locks.LockSupport;

@RestController
public class OrderController {


	@GetMapping("/test")
	public String test(){
		return "hello";
	}
}
