package com.example.mybatis02.mybatis.dao;

import com.example.mybatis02.mybatis.pojo.Role;
import com.example.mybatis02.mybatis.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @date 2020/7/7 11:53
 * @author wei.heng
 */
@Repository
public interface UserRoleDao {

	User getUserByName(String userName);

	List<Role> getRolesByName(String userName);
}
