package module;

import java.util.Scanner;

public class Validator {

	private final static Scanner sc = new Scanner(System.in);

	public Validator() {
	}

	public String inputString(String notification) {
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

	public int inputInt(String notification, int min, int max) {
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

	public double inputDouble(String notification, double min, double max) {
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

	public String inputID(String notification) {
		System.out.print(notification);
		Student student = new Student();
		while (!student.setID(sc.nextLine().trim()))
			;
		return student.getID();
	}

	public String inputEmail(String notification) {
		System.out.print(notification);
		Student student = new Student();
		while (!student.setEmail(sc.nextLine().trim()))
			;
		return student.getEmail();
	}
	
	public String inputPhoneNum(String notification) {
		System.out.print(notification);
		while (true) {
			String phone = sc.nextLine().trim();
			if (phone == null || phone.length() <10 || !phone.matches("[0-9]+")) {
				System.err.print("Error: Invalid phone number, please try again: ");
				continue;
			}
			return phone;
		}
	}
}
