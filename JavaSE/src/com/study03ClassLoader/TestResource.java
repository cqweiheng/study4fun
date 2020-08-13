package com.study03ClassLoader;

import java.util.ListResourceBundle;

public class TestResource extends ListResourceBundle {

	private static final Object[][] contents = {
		{"ch", "中国"},
		{"en", "英国"}
	};

	@Override
	protected Object[][] getContents() {
		return contents;
	}
}
