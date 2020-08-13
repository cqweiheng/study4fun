package com.study05Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PersonInvocationHandler implements InvocationHandler {

	Object target;

	public PersonInvocationHandler(Object t) {
		target = t;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("===========methodName:" + method.getName());
		return method.invoke(target, args);
	}
}
