package br.com.jpb;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public final class DateTimeUtil {

	private DateTimeUtil() {
	}

	public static Date fromLocalDate(LocalDate localDate) {
		return Date.from(
				localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
}
