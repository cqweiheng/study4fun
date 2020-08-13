//package com.example.mybatis02.mybatis.config;
//
//import com.example.mybatis02.mybatis.pojo.Role;
//import com.example.mybatis02.mybatis.pojo.User;
//import com.example.mybatis02.mybatis.service.UserRoleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * 自定义用户认证服务
// * @date 2020/7/7 11:25
// * @author wei.heng
// */
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//	@Autowired
//	private UserRoleService userRoleService;
//
//	@Override
//	@Transactional
//	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//		User user = userRoleService.getUserByName(userName);
//		List<Role> roleList = userRoleService.getRolesByName(userName);
//		return changeToUser(user, roleList);
//	}
//
//	private UserDetails changeToUser(User user, List<Role> roleList){
//		// 权限列表
//		List<GrantedAuthority> authorityList = new ArrayList<>();
//		// 赋予查询到的角色
//		for (Role role : roleList) {
//			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
//			authorityList.add(authority);
//		}
//		// 创建UserDetails对象，设置用户名、密码、权限
//		UserDetails userDetails = new org.springframework.security.core.userdetails.User(
//										user.getUserName(), user.getPwd(), authorityList);
//		return userDetails;
//	}
//}
