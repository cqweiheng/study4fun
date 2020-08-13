package com.algorithm;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class Test003 {


	public static void main(String[] args) {
		method1();
	}

	static Thread t1 = null, t2 = null;

	public static void method2(){
		char[] char1 = "1234567".toCharArray();
		char[] char2 = "ABCDEFG".toCharArray();

		t1 = new Thread(() -> {
			for(char c : char1){
				System.out.print(c);
				LockSupport.unpark(t2);
				LockSupport.park();
			}
		}, "t1");

		t2 = new Thread(() -> {
			LockSupport.park();
			for(char c : char2){
				System.out.print(c);
				LockSupport.unpark(t1);
				LockSupport.park();
			}
		}, "t2");

		t1.start();
		t2.start();
	}

	public static void method1(){
		ReentrantLock reentrantLock = new ReentrantLock();
		Condition condition = reentrantLock.newCondition();

		new Thread(()->{

			try {
				reentrantLock.lock();
				String name = Thread.currentThread().getName();
				for(int i = 1; i <= 26; i++){
	//				System.out.println(name + ":" + i);
					System.out.print(i);
					condition.signal();
					condition.await();
				}
				condition.signal();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				reentrantLock.unlock();
			}

		}, "Thread1").start();

		new Thread(()->{
			try {
				reentrantLock.lock();
				String name = Thread.currentThread().getName();
				for(int i = 65; i <= 90; i++){
					System.out.print((char)i);
	//				System.out.println(name + i + ":" + (char)i);
					condition.signal();
					condition.await();
				}
				condition.signal();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				reentrantLock.unlock();
			}
		}, "Thread2").start();
	}
}
