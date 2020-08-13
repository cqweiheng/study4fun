package com.study09Locale;

import java.text.NumberFormat;
import java.util.Locale;

public class Test01NumberFormat {

	public static void main(String[] args) {

		Locale french = Locale.CHINA;
		NumberFormat format = NumberFormat.getCurrencyInstance(french);
		NumberFormat percentInstance = NumberFormat.getPercentInstance(french);
		double a = 12345.78;
		format.setGroupingUsed(false);
		System.out.println(format.format(a));

		System.out.println(percentInstance.format(0.5));

		NumberFormat numberInstance = NumberFormat.getNumberInstance();
		numberInstance.setParseIntegerOnly(true);
		System.out.println(numberInstance.format(1234.23));
	}
}
