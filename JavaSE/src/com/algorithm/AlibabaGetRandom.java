package com.algorithm;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Random;

/**
 * 有1千万个随机数，随机数的范围在1到1亿之间。现在要求写出一种算法，将1到1亿之间没有在随机数中的数求出来？
 * @date 2020/5/19 10:52
 * @author wei.heng
 */
public class AlibabaGetRandom {

	public static void main(String[] args) {

		Random random = new Random();
		// 创造1000万个随机数
		ArrayList<Integer> randomInt = new ArrayList<>();
		for(int i = 0; i < 10000000; i++){
			int anInt = random.nextInt(100000000);
			randomInt.add(anInt);
		}

		BitSet set = new BitSet();
		set.set(1);
	}
}
