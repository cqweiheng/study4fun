package com.algorithm;


import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * 求第N个斐波那契数: 0,1,1,2,3,5,8,13,21,34....
 * @date 2020/5/18 12:01
 * @author wei.heng
 */
public class Test001 {


	public static void main(String[] args) {
		// 方法1
//		System.out.println(getNum(1) + "," + getNum(2) + "," + getNum(3)
//			+ "," + getNum(4) + "," + getNum(5) + "," + getNum(6) + "," + getNum(7) + "," + getNum(8));

		int n = 50;
		long start = System.currentTimeMillis();
		System.out.println(getNum(n));	// 7778742049
		System.out.println("n:" + n + "，耗时：" + (System.currentTimeMillis() - start));	// n:50，耗时：1

		// 方法2
//		System.out.println(getNum2(1) + "," + getNum2(2) + "," + getNum2(3)
//			+ "," + getNum2(4) + "," + getNum2(5) + "," + getNum2(6) + "," + getNum2(7) + "," + getNum2(8));
		start = System.currentTimeMillis();
		System.out.println(getNum2(n));	// 7778742049
		System.out.println("n:" + n + "，耗时：" + (System.currentTimeMillis() - start));	// n:50，耗时：81158

	}

	// O(n)
	public static long getNum(long n){
		checkNum(n);
		long first = 0;
		long second = 1;
		long thrid = 0;

		if(n == 2){
			thrid = first + second;
		} else if(n > 2){
			// 1 + 5*(n - 2)
			for (int i = 0; i < (n - 2); i++) {
				thrid = first + second;
				first = second;
				second = thrid;
			}
		}
		return thrid;
	}

	// O(2^n)
	public static long getNum2(long n){
		checkNum(n);
		if(n == 1){
			return 0;
		} else if(n == 2){
			return 1;
		}
		return getNum2(n-1) + getNum2(n-2);
	}

	private static void checkNum(long n){
		if(n < 1){
			throw new RuntimeException("入参必须为正整数！");
		}
	}
}
