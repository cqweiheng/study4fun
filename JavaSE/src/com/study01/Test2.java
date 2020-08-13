package com.study01;

import java.io.UnsupportedEncodingException;

public class Test2 {

	/**
	 * 码点数 - 字符串的实际长度，同时也代表了代码单元数
	 */
	public static void main(String[] args) {

		String a = null;
		try {
			a = new String("你好");
			// length方法返回采用UTF-16编码表示的给定字符串所需要的代码单元数量
			System.out.println(a.codePointCount(0,a.length()));	// 码点数：2
			a = new String("你好".getBytes(), "gbk");
			System.out.println(a.codePointCount(0,a.length()));	// 码点数：3
			System.out.println(a.charAt(0));	// 浣
			System.out.println(a.charAt(1));	// 犲
			System.out.println(a.charAt(2));	// ソ
			System.out.println("==============================");
			System.out.println(a.offsetByCodePoints(0,0));	// 码点：0
			System.out.println(a.offsetByCodePoints(0,1));	// 码点：1
			// 码点的获取
			System.out.println(a.codePointAt(0));	// 28003
			System.out.println(a.codePointAt(1));	// 29362
			System.out.println(a.codePointAt(2));	// 12477
			System.out.println("==============================");
			System.out.println((char)a.codePointAt(0));	// 浣
			System.out.println((char)a.codePointAt(1));	// 犲
			System.out.println((char)a.codePointAt(2));	// ソ

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}


	}
}
