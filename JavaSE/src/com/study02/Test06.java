package com.study02;

import java.lang.reflect.InvocationTargetException;

public class Test06 {

	public static void main(String[] args) throws Exception {
		test(String.class);
	}

	public static void test(Class<?> clazz) throws IllegalAccessException, InstantiationException
								, NoSuchMethodException, InvocationTargetException {
		System.out.println(clazz.newInstance());
		System.out.println(clazz.getConstructor(String.class).newInstance("anc"));
		System.out.println();
	}
}
