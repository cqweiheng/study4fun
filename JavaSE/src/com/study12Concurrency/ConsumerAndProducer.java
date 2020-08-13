package com.study12Concurrency;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 生产消费者
 * @date 2020/5/24 22:57
 * @author wei.heng
 */
public class ConsumerAndProducer {

	public static void main(String[] args) {

		ArrayList<Product> products = new ArrayList<>();

		ReentrantLock lock = new ReentrantLock();
//		ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
//		ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
//		ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();

		Condition productCondition = lock.newCondition();
		// 创造10个消费者
		for (int i = 0; i < 10; i++) {
			new Thread(()-> {
				while(true){
					try {
						TimeUnit.MILLISECONDS.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					lock.lock();
					System.out.println(Thread.currentThread().getName() + "：我拿到锁了");
					if(products.isEmpty()){
						// 没有库存了，等在这里
						try {
							productCondition.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else {
						// 还有库存，进行消费
						Product remove = products.remove(0);
						System.out.println(Thread.currentThread().getName() + "消费了一个商品：" + remove.getName());
						try {
							TimeUnit.MILLISECONDS.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					lock.unlock();
				}
			}, "Consumer" + i).start();
		}

		// 创建 3个生产者
		AtomicInteger prodIndex = new AtomicInteger();
		for (int i = 0; i < 3; i++) {
			new Thread(()-> {
				String threadName = Thread.currentThread().getName();
				while(true){
					lock.lock();
					if(products.isEmpty()){
						// 开始生产, 一个生产者一次生产5个
						for (int j = 0; j < 5; j++) {
							Product newProduct = new Product("商品" + threadName + "-" + prodIndex.get(), new BigDecimal(20));
							products.add(newProduct);
							System.out.println(Thread.currentThread().getName() + "生产了一个商品：" + newProduct.getName());
							try {
								TimeUnit.MILLISECONDS.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							prodIndex.incrementAndGet();
						}
						// 唤醒所有
						productCondition.signalAll();
					}
					lock.unlock();
				}
			}, "Producer" + i).start();
		}
		
		
	}
}
