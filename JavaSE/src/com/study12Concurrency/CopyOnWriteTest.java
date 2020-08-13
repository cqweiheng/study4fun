package com.study12Concurrency;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

public class CopyOnWriteTest {

	static CopyOnWriteArrayList<String> list;

	public static void main(String[] args) {
		String[] arr = {"111","222","333"};
		list = new CopyOnWriteArrayList(arr);

		System.out.println(list);
		list.set(0, "555");
		System.out.println(list);

		new Thread(()->{
			String name = Thread.currentThread().getName();
			System.out.println(name + "============");
			System.out.println(name + list);
			list.add("6666");
			System.out.println(name + list);
			try {
				TimeUnit.MILLISECONDS.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + "============end");
		},"Thread1").start();

		new Thread(()->{
			String name = Thread.currentThread().getName();
			System.out.println(name + "============");
			System.out.println(name + list);
			for (String s : arr) {
				System.out.println("arr:" + s);
			}
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + "============end");
		},"Thread2").start();
	}

}
