package com.algorithm;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * 求200万以内的所有素数
 * @date 2020/5/19 11:27
 * @author wei.heng
 */
public class GetPrimeNumber {

	public static void main(String[] args) {

		System.out.println(1%2);
	}

	public static void getPrime2(){


	}

	public static void getPrime(){
		int n = 2000000;
		BitSet b = new BitSet(n+1);
		int count = 0;
		int i;
		for (i = 2; i <= n; i++) {
			b.set(i);
		}
		i = 2;
		while(i*i <= n){
			if(b.get(i)){
				count++;
				int k = 2*i;
				// 把2和i成倍数关系的数字，都删掉
				while(k <= n){
					b.clear(k);
					k += i;
				}
			}
			i++;
		}
		while(i <= n){
			if(b.get(i)){
				count++;
			}
			i++;
		}
	}

}
