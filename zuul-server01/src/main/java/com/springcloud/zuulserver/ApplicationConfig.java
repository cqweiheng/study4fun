package com.springcloud.zuulserver;

import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @date 2020/8/2 17:38
 * @author wei.heng
 */
@Configuration
public class ApplicationConfig {

	@Bean
	public PatternServiceRouteMapper patternServiceRouteMapper() {
		//定义用来匹配服务的正则表达式
		String servicePattern="(?<name>^.+)-(?<version>v.+$)";
		//定义用来匹配路径的正则表达式
		String routePattern="${version}/${name}";
		return new PatternServiceRouteMapper(servicePattern, routePattern);
	}

	/***
	 *
	 * 配置过滤器
	 * @return com.springcloud.zuulserver.PermissionFilter
	 * @date 2020/8/2 17:38
	 * @author wei.heng
	 */
	@Bean
	public PermissionFilter permissionFilter() {
		return new PermissionFilter();
	}


}
