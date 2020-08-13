package com.study12Concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteTest {
	ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
	ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

	public static void main(String[] args) {

		ReadWriteTest readWriteTest = new ReadWriteTest();
		new Thread(()->{
			readWriteTest.testWrite();
		},"WriteThread").start();
		new Thread(()->{
			readWriteTest.testRead();
		},"ReadThread").start();
		new Thread(()->{
			readWriteTest.testRead();
		},"ReadThread2").start();


	}

	public void testRead(){
		String name = Thread.currentThread().getName();
		System.out.println(name + "：我要获取读锁");
		readLock.lock();
		System.out.println(name + "：我拿到读锁了");
		while (true){
			try {
				System.out.println(name + "：readLock.............");
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void testWrite(){
		String name = Thread.currentThread().getName();
		System.out.println(name + "：我要获取写锁");
		writeLock.lock();
		System.out.println(name + "：我拿到写锁了");
		while (true){
			try {
				System.out.println(name + "：writeLock.............");
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
