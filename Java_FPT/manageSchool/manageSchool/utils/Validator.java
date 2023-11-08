package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validator {

	private final static Scanner sc = new Scanner(System.in);
	private final static SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");

	public Validator() {
	}

	public static String inputString(String notification) {
		System.out.print(notification);
		while (true) {
			String result = sc.nextLine().trim();
			if (result == null || result.length() == 0) {
				System.err.print("Error: Invalid input, please try again: ");
				continue;
			}
			return result;
		}
	}

	public static int inputInt(String notification, int min, int max) {
		System.out.print(notification);
		int number = 0;
		while (true) {
			try {
				number = Integer.parseInt(sc.nextLine().trim());
			} catch (NumberFormatException e) {
				System.err.print("Error: Invalid input, please try again: ");
				continue;
			}
			if (number < min || number > max) {
				System.err.print("Error: Invalid input, please try again: ");
				continue;
			}
			return number;
		}
	}

	public static double inputDouble(String notification, double min, double max) {
		System.out.print(notification);
		double number = 0;
		while (true) {
			try {
				number = Double.parseDouble(sc.nextLine().trim());
			} catch (NumberFormatException e) {
				System.err.print("Error: Invalid input, please try again: ");
				continue;
			}
			if (number < min || number > max) {
				System.err.print("Error: Invalid input, please try again: ");
				continue;
			}
			return number;
		}
	}

	public static String inputPhoneNum(String notification) {
		System.out.print(notification);
		while (true) {
			String result = sc.nextLine().trim();
			if (result == null || result.length() < 10 || !result.matches("[0-9]+")) {
				System.err.print("Error: Invalid input, please try again: ");
				continue;
			}
			return result;
		}
	}

	public static String inputEmail(String notification) {
		System.out.print(notification);
		while (true) {
			String result = sc.nextLine().trim();
			if (result == null || !result.contains("@") || result.contains(" ")) {
				System.err.print("Error: Invalid input, please try again: ");
				continue;
			}
			return result;
		}
	}

	public static Date inputDate(String notification) {
		System.out.print(notification);
		formatDate.setLenient(false);
		while (true) {
			String result = sc.nextLine().trim();
			Date date = null;
			try {
				date = formatDate.parse(result);
			} catch (ParseException e) {
				System.err.print("Error: Invalid input, please try again: ");
				continue;
			}
			if (result == null || result.length() == 0) {
				System.err.print("Error: Invalid input, please try again: ");
				continue;
			}
			return date;
		}
	}

	public static Date parseDate(String dateString) {
		Date date = null;
		try {
			date = formatDate.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}