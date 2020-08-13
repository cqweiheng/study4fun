package com.study12Concurrency;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;

public class CompletableFutureTest {

	public static void main(String[] args) throws Exception{
		new CompletableFutureTest().futureTest();
//		new CompletableFutureTest().thenApplyTest();
	}

	/**
	 * @date 2020/5/29 11:36
	 * @author wei.heng
	 */
	public void futureTest() {
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("future1 finished!");
			return "future1 finished!";
		});
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
			System.out.println("future2 finished!");
			return "future2 finished!";
		});
		CompletableFuture<Void> combindFuture = CompletableFuture.allOf(future1, future2);
		try {
			System.out.println("========1");
			Void aVoid = combindFuture.get();
//			System.out.println(aVoid.toString());// java.lang.NullPointerException
			System.out.println("========2");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("future1: " + future1.isDone() + " future2: " + future2.isDone());
	}

	/**
	 * @date 2020/5/29 11:27
	 * @author wei.heng
	 */
	public void thenApplyTest() throws Exception {
		CompletableFuture<Long> future = CompletableFuture.supplyAsync(()->{
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int result = 5;
			System.out.println("result1="+result);
			return result;
		}).thenApply(t -> {
			long result = t*5;
			System.out.println("result2="+result);
			return result;
		});

		System.out.println("==========thenApply1");
		long result = future.get();
		System.out.println("==========thenApply2");
		System.out.println(result);
	}
}
