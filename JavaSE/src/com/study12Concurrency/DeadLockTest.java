package com.study12Concurrency;

public class DeadLockTest {

	public static final int NACCOUNTS = 2;
	public static final double INITIAL_BALANCE = 1000;
	public static final int DELAY = 300;

	public static void main(String[] args) {

		Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
		new Thread(()-> {
			try {
				while(true){
					double amount = 1005d;
					bank.transfer(0, 1, amount);
					Thread.sleep(DELAY);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "ThreadAA").start();

		new Thread(()-> {
			try {
				while(true){
					double amount = 1005d;
					bank.transfer(1, 0, amount);
					Thread.sleep(DELAY);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "ThreadBB").start();

	}
}
