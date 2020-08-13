package com.study12Concurrency;

import java.util.concurrent.atomic.LongAdder;

public class BankAccount {

	private int id;

	int money;

	public BankAccount(int id, int money) {
		this.id = id;
		this.money = money;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public synchronized int getMoney() {
		return money;
	}

	public synchronized void setMoney(int money) {
		this.money = money;
	}

	public synchronized void randomRransfer(BankAccount to, int money){
		// 随机转账金额
		this.money -= money;
		to.setMoney(to.getMoney() + money);
	}
}
