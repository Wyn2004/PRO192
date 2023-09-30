package module;

public class Day {

	private int day;
	private int month;
	private int year;
	Validator validator=  new Validator();

	public Day() {
	}

	public Day(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public void inputBirth() {

		System.out.println("Enter birthday ");
		while(!setDay(validator.inputInt("Enter day: ", 1, 31)));
		while(!setDay(validator.inputInt("Enter month: ", 1, 12)));
		while(!setDay(validator.inputInt("Enter year: ", 1, 999999)));

	}

	public int getDay() {
		return day;
	}

	public boolean setDay(int day) {
		this.day = day;
		return true;
	}

	public int getMonth() {
		return month;
	}

	public boolean setMonth(int month) {
		this.month = month;
		return true;
	}

	public int getYear() {
		return year;
	}

	public boolean setYear(int year) {
		this.year = year;
		return true;
	}

	@Override
	public String toString() {
		return "Day [day=" + day + ", month=" + month + ", year=" + year + "]";
	}
}
