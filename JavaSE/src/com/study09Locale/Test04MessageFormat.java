package com.study09Locale;

import java.text.FieldPosition;
import java.text.MessageFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

public class Test04MessageFormat {

	public static void main(String[] args) {

		System.out.printf("Heelo%nWorld%n");

		String pattern = "On {2,date,medium}, {0} destroyed {1,choice,0#no houses|1#one house|2#{1} houses}"
				+ " and caused {3,number,currency} of damage ";
//		ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDate.of(1988, 5, 20)
//				, LocalTime.of(12, 12), ZoneId.systemDefault());
//		String format = MessageFormat.format(pattern, new Object[]{"a earthquake", 1
//			, Date.from(zonedDateTime.toInstant()), 50000000});

		Date from = Date.from(LocalDateTime.of(1988, 5, 20, 12, 12).atZone(ZoneId.systemDefault()).toInstant());
		String format = MessageFormat.format(pattern, new Object[]{"a earthquake", 5
			, from, 50000000});
		System.out.println(format);

		MessageFormat messageFormat = new MessageFormat(" test  , {1} {0}");
		StringBuffer buffer = messageFormat.format(new Object[]{"hello", "message"}
			, new StringBuffer("stringbuffer"), new FieldPosition(1));
		System.out.println(buffer);
	}
}
