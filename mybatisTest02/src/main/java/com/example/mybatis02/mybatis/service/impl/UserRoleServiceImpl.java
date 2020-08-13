package com.example.mybatis02.mybatis.service.impl;

import com.example.mybatis02.mybatis.dao.UserRoleDao;
import com.example.mybatis02.mybatis.pojo.Role;
import com.example.mybatis02.mybatis.pojo.User;
import com.example.mybatis02.mybatis.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleDao userRoleDao;

	@Override
	public User getUserByName(String userName) {
		return userRoleDao.getUserByName(userName);
	}

	@Override
	public List<Role> getRolesByName(String userName) {
		return userRoleDao.getRolesByName(userName);
	}

}
