package module;

import java.util.Scanner;

public class Day {

	private int day;
	private int month;
	private int year;

	public Day() {
	}

	public Day(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public void inputBirth() {

		@SuppressWarnings("resource")
		Scanner inputDay = new Scanner(System.in);
		System.out.print("Enter birthday (separated by spaces): ");
		this.day = inputDay.nextInt();
		this.month = inputDay.nextInt();
		this.year = inputDay.nextInt();

	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Day [day=" + day + ", month=" + month + ", year=" + year + "]";
	}
}
