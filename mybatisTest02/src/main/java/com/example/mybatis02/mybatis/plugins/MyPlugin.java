package com.example.mybatis02.mybatis.plugins;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Connection;
import java.util.Properties;

@Intercepts({
	@Signature(type= StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})
})
public class MyPlugin implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		System.out.println("===============插件拦截myplugin");
		return invocation.proceed();
	}

	/**
	 *
	 * 生成mybatis插件代理对象，这个需要自己实现动态代理
	 * @param target 目标对象
	 * @return java.lang.Object
	 * @date 2020/6/21 8:48
	 * @author wei.heng
	 */
	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	/**
	 *
	 * 设置插件属性
	 * @param properties 属性对象
	 * @date 2020/6/21 8:51
	 * @author wei.heng
	 */
	@Override
	public void setProperties(Properties properties) {

	}
}
