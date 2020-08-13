//package com.example.mybatis02.mybatis.config;
//
//import org.springframework.security.access.ConfigAttribute;
//import org.springframework.security.access.SecurityConfig;
//import org.springframework.security.web.FilterInvocation;
//import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.security.web.util.matcher.RequestMatcher;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//
//public class FilterSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
//
//	private final Map<RequestMatcher, Collection<ConfigAttribute>> requestMap;
//
//	@Override
//	public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
//		FilterInvocation fi = (FilterInvocation) o;
//		HttpServletRequest request = fi.getRequest();
//		String url = fi.getRequestUrl();
//		String httpMethod = fi.getRequest().getMethod();
//
//		// Lookup your database (or other source) using this information and populate the
//		// list of attributes (这里初始话你的权限数据)
//		//List<ConfigAttribute> attributes = new ArrayList<ConfigAttribute>();
//
//		//遍历我们初始化的权限数据，找到对应的url对应的权限
//		for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap
//			.entrySet()) {
//			if (entry.getKey().matches(request)) {
//				return entry.getValue();
//			}
//		}
//		return null;
//	}
//
//	@Override
//	public Collection<ConfigAttribute> getAllConfigAttributes() {
//		return null;
//	}
//
//	@Override
//	public boolean supports(Class<?> aClass) {
//		return false;
//	}
//
//	/*
//	 * 初始化url权限数据，保证在 getAttributes()之前初始好数据
//	 */
//	public FilterSecurityMetadataSource() {
//		Map<RequestMatcher, Collection<ConfigAttribute>> map = new HashMap<>();
//
//		AntPathRequestMatcher matcher = new AntPathRequestMatcher("/home");
//		SecurityConfig config = new SecurityConfig("ROLE_ADMIN");
//		ArrayList<ConfigAttribute> configs = new ArrayList<>();
//		configs.add(config);
//		map.put(matcher,configs);
//
//		AntPathRequestMatcher matcher2 = new AntPathRequestMatcher("/");
//		SecurityConfig config2 = new SecurityConfig("ROLE_ADMIN");
//		ArrayList<ConfigAttribute> configs2 = new ArrayList<>();
//		configs2.add(config2);
//		map.put(matcher2,configs2);
//		this.requestMap = map;
//	}
//}
