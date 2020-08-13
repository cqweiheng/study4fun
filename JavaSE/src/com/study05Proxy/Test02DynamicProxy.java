package com.study05Proxy;

import com.study01.IPersonBean;
import com.study01.PersonBean;

import java.lang.reflect.Proxy;

public class Test02DynamicProxy {

	public static void main(String[] args) {
		IPersonBean p = new PersonBean("妹妹");
		IPersonBean proxy = getProxy(p);
		System.out.println(proxy.getName());

	}

	private static IPersonBean getProxy(IPersonBean p) {
		return (IPersonBean) Proxy
				.newProxyInstance(p.getClass().getClassLoader(), p.getClass().getInterfaces(), new PersonInvocationHandler(p));
	}


}
