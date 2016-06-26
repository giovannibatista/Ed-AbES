package br.com.edabes.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static String getDateFormatString() {

	LocalDateTime dataAtual = LocalDateTime.now();
	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:SS");
	String data = dataAtual.format(dateTimeFormatter);

	return data;
    }

    public static LocalDateTime getDateFormat() {

	LocalDateTime dataAtual = LocalDateTime.now();
	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:SS");
	dataAtual.format(dateTimeFormatter);

	return dataAtual;
    }

}
