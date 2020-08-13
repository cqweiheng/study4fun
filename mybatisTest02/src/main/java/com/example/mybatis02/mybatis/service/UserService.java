package com.example.mybatis02.mybatis.service;

import com.example.mybatis02.mybatis.pojo.User;

public interface UserService {

	User getUser(Long id);

	boolean updateUserName(Long id, String userName);

	int insertUser(User user);
}
