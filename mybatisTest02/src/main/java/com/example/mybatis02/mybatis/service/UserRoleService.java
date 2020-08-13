package com.example.mybatis02.mybatis.service;

import com.example.mybatis02.mybatis.pojo.Role;
import com.example.mybatis02.mybatis.pojo.User;

import java.util.List;

public interface UserRoleService {

	User getUserByName(String userName);

	List<Role> getRolesByName(String userName);
}
