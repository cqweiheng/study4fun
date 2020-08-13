package com.study03ClassLoader;

import com.study03ClassLoader.bean.Person;
import sun.security.ec.CurveDB;

public class Test01 {

	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

		ClassLoader mainLoader = Test01.class.getClassLoader();
		System.out.println(mainLoader.getClass().getName());
		Class<?> mainClass = mainLoader.loadClass("sun.security.ec.CurveDB");
		Object o1 = mainClass.newInstance();
		System.out.println("111");
		CurveDB mp = (CurveDB) o1;
		System.out.println("CurveDB:" + mp);
		System.out.println("===================");

		Class<?> aClass = Class.forName("com.study03ClassLoader.bean.Person");
		ClassLoader classLoader = aClass.getClassLoader();
		System.out.println("ClassLoaderName:" + classLoader.getClass().getName());
		Object o = aClass.newInstance();
		Person p = (Person)o;
		System.out.println(p);
	}

}
