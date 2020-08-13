package com.study01;


public class Test5 {

	public static String s = "";

	private String t = "t";

	{
		s = "3";
	}
	/**
	 *
	 */
	public static void main(String[] args) {
		System.out.println(s);
		Child p = new Child();
//		Runtime.getRuntime().addShutdownHook();
	}
}
