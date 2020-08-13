package com.study08TimeAPI;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Test02LocalDate {

	public static void main(String[] args) {

		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		LocalDateTime of = LocalDateTime.of(LocalDate.now(), LocalTime.now());
		System.out.println(of);
		System.out.println(formatter.format(of));

		String format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss[VV]").format(of);
		System.out.println(format);

//		LocalDate date = LocalDate.of(2020, 12, 31);
//		System.out.println(LocalDate.now().until(date, ChronoUnit.WEEKS));
//		System.out.println(date.getMonth().getValue());
//
//		System.out.println(DayOfWeek.MONDAY.getValue());
//		System.out.println(Month.JANUARY);
//
//		TemporalAdjuster NEXT_WORKDAY = new TemporalAdjuster() {
//			@Override
//			public Temporal adjustInto(Temporal temporal) {
//				return null;
//			}
//		};
//
//		Duration duration = Duration.ofDays(1);
//		Period period = Period.ofDays(1);
	}
}
