package com.study01;


import java.util.Date;

public class Test3 {

	/**
	 *
	 */
	public static void main(String[] args) {
		System.out.printf("%,+.2f", 10000.0/3.0);
		System.out.println();
		System.out.printf("%1$s %2$tB %2$te, %2$tY", "Due Date：", new Date());
		System.out.println();
		System.out.printf("%s %tB %<te, %<tY", "Due Date：", new Date());
	}
}
