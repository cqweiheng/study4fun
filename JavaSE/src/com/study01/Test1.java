package com.study01;

public class Test1 {

	/**
	 * == 比较地址
	 * equals 比较值
	 */
	public static void main(String[] args) {
		String a = "aa";
		String b = "aa";
		System.out.println(a == b); // true
		b = "aab".substring(0,2);
		System.out.println(b);	// aa
		System.out.println(a == b);// false

	}
}
