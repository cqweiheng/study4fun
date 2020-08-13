package com.study09Locale;

import java.util.Currency;

public class Test02Currency {

	public static void main(String[] args) {

		for (Currency currency : Currency.getAvailableCurrencies()) {
			System.out.println(currency.getCurrencyCode() + ":" + currency.getDisplayName());
		}
	}
}
