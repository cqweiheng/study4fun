package com.study12Concurrency;

import java.util.Random;
import java.util.concurrent.*;

/**
 *
 * @date 2020/5/29 17:09
 * @author wei.heng
 */
public class PhaserTest {

	public static void main(String[] args) {

		class Working implements Runnable {
			private String name;
			private Phaser ph;
			private int period = 3;

			private Working(String name, Phaser ph) {
				this.name = name;
				this.ph = ph;
				// 每创建一个runnable，我们就注册一个party
				ph.register();
			}

			@Override
			public void run() {

				for (int i = 1; i <= period; i++) {
					System.out.println(name + ":我开始第" + i + "阶段的工作了");
					int workingTime = 0;
					try {
						workingTime = new Random().nextInt(10);
						TimeUnit.SECONDS.sleep(workingTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ph.arriveAndAwaitAdvance();
					System.out.println(name + ":" + ph.getPhase() + "," + ph.getArrivedParties() + ","
						+ ph.getUnarrivedParties() + "," + ph.getRegisteredParties());
					System.out.println(name + ":我第" + i + "阶段的工作做完了, 耗时" + workingTime + "秒");
				}
				ph.arriveAndDeregister();
			}

		}

		// 创建一个线程池来管理所有的工作
		ExecutorService executorService = new ThreadPoolExecutor(5, 20
			, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(16)
			, r -> new Thread(r, "TestThread"));
		// 注册一个阶段器，初始化管理的线程数为3 - 如果这里初始化了，就不用在Working 的构造方法中进行register了
		// Phaser ph = new Phaser(3);
		// 注册一个阶段器
		Phaser ph = new Phaser();
		executorService.submit(new Working("thread-1", ph));
		executorService.submit(new Working("thread-2", ph));
		executorService.submit(new Working("thread-3", ph));
	}

}
