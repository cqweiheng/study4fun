package com.example.springboot.interceptor;

import java.lang.reflect.InvocationTargetException;

public interface Interceptor {

	// 事前方法
	boolean before();
	// 事后方法
	void after();
	// 取代原有事件方法
	Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException;
	// 时候返回方法，事件没有发生异常
	void afterReturning();
	// 事后异常方法，事件发生异常后
	void afterThrowing();
	// 是否使用around方法取代原有方法
	boolean useAround();
}
