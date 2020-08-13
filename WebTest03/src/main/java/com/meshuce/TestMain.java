package com.meshuce;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class TestMain {

	/**
	 *
	 * 这里用比较装逼的写法，同时启动10个线程
	 * @param args
	 * @date 2020/1/13 22:12
	 * @author wei.heng
	 */
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		
		try {
			// 启动后等个10秒吧，观察下JProfiler的线程状态
			TimeUnit.SECONDS.sleep( 5 );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
		List<FutureTask<String>> tasks = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			FutureTask<String> futureTask = new FutureTask<>(new MyThreadd(cyclicBarrier));
			tasks.add(futureTask);
			new Thread(futureTask, "ThreadIndex" + i).start();
		}

		for (int i = 0; i < tasks.size(); i++) {
			System.out.println(tasks.get(i).get());
		}
	}

	public static class MyThreadd implements Callable<String> {

		private CyclicBarrier cyclicBarrier;

		public MyThreadd(CyclicBarrier cyclicBarrier) {
			this.cyclicBarrier = cyclicBarrier;
		}

		@Override
		public String call() throws Exception {

			String[] lockArr = {"lockA", "lockB"};
			String lockFirst = lockArr[new Random().nextInt(2)];
			System.out.println(Thread.currentThread().getName() + " 我在等待锁1:" + lockFirst);

			// 设置栅栏
			cyclicBarrier.await();
			// intern() 方法保证多线程内始终是这两把锁
			synchronized (lockFirst.intern()) {

				System.out.println(Thread.currentThread().getName() + ": 我拿到了锁1：" + lockFirst);
				TimeUnit.SECONDS.sleep(1);

				// 我再数组里随机获取一把（多线程的话，这就有可能出现死锁了）
				String lockSecond = lockArr[new Random().nextInt(2)];
				System.out.println(Thread.currentThread().getName() + " 我在等待锁2:" + lockSecond);
				synchronized (lockSecond.intern()) {
					System.out.println(Thread.currentThread().getName() + ": 我拿到了锁2：" + lockSecond);
				}
				System.out.println(Thread.currentThread().getName() + ": 我释放了锁2：" + lockSecond);
			}
			System.out.println(Thread.currentThread().getName() + ": 我释放了锁1：" + lockFirst);
			return Thread.currentThread().getName() + " 哼哼~ ";
		}
	}

}
