package com.example.mybatis02.mybatis.plugins;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

@Intercepts({
	@Signature(type= Executor.class, method = "update", args = {MappedStatement.class, Object.class})
})
public class ParamsPlugin implements Interceptor {

	private static final String CREATE_TIME = "createDate";
	private static final String UPDATE_TIME = "updateDate";

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		System.out.println("===============插件拦截params");
		// 操作命令
		MappedStatement statement = (MappedStatement)invocation.getArgs()[0];
		// 获取SQL操作类型
		SqlCommandType sqlCommandType = statement.getSqlCommandType();
		// 获取新增或修改的参数对象
		Object parameter = invocation.getArgs()[1];

		return invocation.proceed();
	}

	/**
	 *
	 * 生成mybatis插件代理对象
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
