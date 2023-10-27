package Controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class app {
	public static void main(String[] args) throws ParseException {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		String str = "31/02/2020";
		LocalDate date = LocalDate.parse(str, formatter);
		System.out.println(date);
		System.out.println(date.equals(LocalDate.parse(str,formatter)));
	}
}
