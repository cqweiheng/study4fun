package com.study12Concurrency;

import java.util.concurrent.TimeUnit;

public class InterruptTest {

	public static void main(String[] args) {

		Thread t = new Thread(()-> {
			long start = System.currentTimeMillis();
			while(true){
//				System.out.println("====================" + System.currentTimeMillis());
				try {
					TimeUnit.SECONDS.sleep(10);
				} catch (InterruptedException e) {
					System.out.println("=========== interrupted 等待时间:" + (System.currentTimeMillis() - start));
					e.printStackTrace();
					return;
				}
				if(Thread.currentThread().isInterrupted()){
					System.out.println("==============当前线程被打断");
					try {
						TimeUnit.SECONDS.sleep(10);
					} catch (InterruptedException e) {
						System.out.println("=========== interrupted 等待时间:" + (System.currentTimeMillis() - start));
						e.printStackTrace();
						return;
					}
				}
			}
//			try {
//				TimeUnit.SECONDS.sleep(10);
//			} catch (InterruptedException e) {
//				System.out.println("=========== interrupted 等待时间:" + (System.currentTimeMillis() - start));
//				e.printStackTrace();
//			}
//			System.out.println("======waiting");
//			try {
//				TimeUnit.SECONDS.sleep(10);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		});
		System.out.println("== state:" + t.getState());
		t.start();
		System.out.println("==状态：" + t.isInterrupted());
		System.out.println("== state:" + t.getState());
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("== state:" + t.getState());
		t.interrupt();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("==状态：" + t.isInterrupted());
		System.out.println("== state:" + t.getState());
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("== state:" + t.getState());
		System.exit(0);
	}
}
