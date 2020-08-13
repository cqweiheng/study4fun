package com.study12Concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTest {



	//测试类
	public static void main(String[] args) {

		class MyThread extends Thread {
			private CyclicBarrier cyclicBarrier;
			private String name;

			public MyThread(CyclicBarrier cyclicBarrier, String name) {
				super();
				this.cyclicBarrier = cyclicBarrier;
				this.name = name;
			}

			@Override
			public void run() {
				System.out.println(name + "开始准备");
				try {
					TimeUnit.SECONDS.sleep(5);
					System.out.println(name + "准备完毕！等待发令枪");
					try {
						System.out.println(name + "===1");
						cyclicBarrier.await();
						System.out.println(name + "===2");
					} catch (BrokenBarrierException e) {
						e.printStackTrace();
					}
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
		}

		CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {
			@Override
			public void run() {
				System.out.println("发令枪响了，跑！");

			}
		});
		for (int i = 0; i < 5; i++) {
			new MyThread(barrier, "运动员" + i + "号").start();
		}

	}

}
