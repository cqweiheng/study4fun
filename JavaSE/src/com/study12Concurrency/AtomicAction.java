package com.study12Concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicAction {

	public static void main(String[] args) {

		for (int i = 0; i < 100; i++) {
			System.out.println(Math.random());
		}

//		AtomicInteger i = new AtomicInteger(5);
//		i.accumulateAndGet(1, Math::max);
//		System.out.println(i.get());
	}
}
