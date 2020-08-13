package com.example.springboot.service;

import com.example.springboot.pojo.User;

public interface UserService {
	void printUser(User user);
	User getUser(String id);
}
