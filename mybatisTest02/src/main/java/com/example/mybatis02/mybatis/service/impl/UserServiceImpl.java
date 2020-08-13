package com.example.mybatis02.mybatis.service.impl;

import com.example.mybatis02.mybatis.dao.UserDao;
import com.example.mybatis02.mybatis.pojo.User;
import com.example.mybatis02.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
//	@Async
	public User getUser(Long id) {
		User user = userDao.getUser(id);
		System.out.println("==============11");
		System.out.println(user.getUserName());
		return user;
	}

	@Override
	public boolean updateUserName(Long id, String userName) {
		return userDao.updateUserName(id, userName);
	}

	@Override
	@Transactional(timeout = 1, isolation = Isolation.READ_COMMITTED)
	public int insertUser(User user) {
		return userDao.insertUser(user);
	}
}
