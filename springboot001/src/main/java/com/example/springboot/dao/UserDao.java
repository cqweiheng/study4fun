package com.example.springboot.dao;

import com.example.springboot.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

	public User getUser(Long id);
}
