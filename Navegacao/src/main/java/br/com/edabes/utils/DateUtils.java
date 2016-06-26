package br.com.edabes.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

	public static String getDateFormatString() {

		LocalDateTime dataAtual = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmSS");
		String data = dataAtual.format(dateTimeFormatter);

		return data;
	}
	
	public static LocalDateTime getDateFormat() {

		LocalDateTime dataAtual = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmSS");
		dataAtual.format(dateTimeFormatter);

		return dataAtual;
	}

}
