package br.com.jpb.superlogica;

import java.time.format.DateTimeFormatter;

public final class Constants {

	private Constants() {
	}

	public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter
			.ofPattern("MM/dd/yyyy");

	public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter
			.ofPattern("MM/dd/yyyy HH:mm:ss");

}
