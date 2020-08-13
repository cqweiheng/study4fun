package com.study07Collection;

import java.time.LocalDate;
import java.util.PriorityQueue;

public class Test02PriorityQueue {

	public static void main(String[] args) {

		PriorityQueue<LocalDate> pq = new PriorityQueue<>();
		pq.add(LocalDate.of(1906, 12, 9));
		pq.add(LocalDate.of(1815, 12, 10));
		pq.add(LocalDate.of(1903, 12, 3));
		pq.add(LocalDate.of(1910, 6, 22));
		System.out.println("=========");

		for (LocalDate date : pq) {
			System.out.println(date);
		}
		System.out.println("removing ........");
		while(!pq.isEmpty()){
			System.out.println(pq.remove());
		}
	}
}
