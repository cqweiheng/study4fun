package com.example.springboot.mapper;

import com.example.springboot.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

	@Select("SELECT * FROM users WHERE id = #{userId}")
	User getUser(@Param("userId") String userId);
}
