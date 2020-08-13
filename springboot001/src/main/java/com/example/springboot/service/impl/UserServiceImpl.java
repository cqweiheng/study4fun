package com.example.springboot.service.impl;

import com.example.springboot.dao.UserDao;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.pojo.User;
import com.example.springboot.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	@Autowired
	UserMapper userMapper;

	@Override
	public void printUser(User user) {
		if(user == null){
			throw new RuntimeException("用户参数为空");
		}
		System.out.println("usernam:" + user.getUserName());
	}

	@Override
	public User getUser(String id){
//		User user = userDao.getUser(id);
		User user = userMapper.getUser(id);
		return user;
	}
}
