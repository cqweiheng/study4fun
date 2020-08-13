package com.example.mybatis02.mybatis.dao;

import com.example.mybatis02.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @date 2020/7/7 11:53
 * @author wei.heng
 */
@Repository
public interface UserDao {

	User getUser(@Param("id") Long id);

	boolean updateUserName(@Param("id")Long id, @Param("userName")String userName);

	int insertUser(User user);
}
