package Kalender;

import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Locale;


class Date {

	public static String dateGetter(int x) {
		LocalDate today = LocalDate.now();
		TemporalField fieldISO = WeekFields.of(Locale.FRANCE).dayOfWeek();
		LocalDate date = today.with(fieldISO, x);
		String getDate = date.toString();
		return getDate;
		
	}
	
	}

