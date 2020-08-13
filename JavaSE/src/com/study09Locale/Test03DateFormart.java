package com.study09Locale;

import java.text.FieldPosition;
import java.text.MessageFormat;
import java.time.DayOfWeek;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class Test03DateFormart {

	public static void main(String[] args) {

		System.out.println(Locale.getDefault().getCountry() + ":" + Locale.getDefault().getDisplayName());
		DayOfWeek day = WeekFields.of(Locale.getDefault()).getFirstDayOfWeek();
		System.out.println(day);
	}
}
