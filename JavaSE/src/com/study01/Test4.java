package com.study01;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test4 {

	/**
	 *
	 */
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		date = LocalDate.of(2016, 5,31);
		LocalDate d2 = LocalDate.of(2016,6,20);
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		System.out.println(dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE));
		System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		System.out.println(dateTime.format(DateTimeFormatter.BASIC_ISO_DATE));
//		System.out.println(dateTime.format(DateTimeFormatter.));
	}
}
