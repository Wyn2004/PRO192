package module;

import java.util.Objects;
import java.util.Scanner;

public class Student extends Person {

	private String ID;
	private double average;
	private String email;
	Validator validator = new Validator();

	public Student() {
	}

	public Student(String ID) {
		this.ID = ID;
	}

	public Student(String name, String gender, Day birthDay, String adress, String ID, double average, String email) {
		super(name, gender, birthDay, adress);
		this.ID = ID;
		this.average = average;
		this.email = email;
	}

	@Override
	public void inputInfo() {

		super.inputInfo();
		@SuppressWarnings("resource")
		Scanner inputStudent = new Scanner(System.in);

		System.out.print("Enter student ID (8 character): ");
		while (!setID(inputStudent.nextLine()));
		this.average = validator.inputDouble("Enter average point: ", 0, 10);
		System.out.print("Enter email: ");
		while (!setEmail(inputStudent.nextLine()));

	}

	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println(toStringStudent());
	}

	public String getID() {
		return ID;
	}

	public boolean setID(String ID) {
		if (ID != null && ID.length() == 8) {
			this.ID = ID;
			return true;
		} else {
			System.err.print("Error... Enter again Student ID (8 character): ");
			return false;
		}
	}

	public double getAverage() {
		return average;
	}

	public boolean setAverage(double average) {
		if (average >= 0 && average <= 10) {
			this.average = average;
			return true;
		} else {
			System.err.print("Error... Enter again average: ");
			return false;
		}
	}

	public String getEmail() {
		return email;
	}

	public boolean setEmail(String email) {
		if (email != null && email.contains("@") && !email.contains(" ")) {
			this.email = email;
			return true;
		} else {
			System.err.print("Error... Enter again email (contain '@'): ");
			return false;
		}

	}

	public boolean checkScholarship() {
		if (this.getAverage() >= 8)
			return true;
		else
			return false;
	}

	public String toStringStudent() {
		return " Student: [ID=" + ID + ", average=" + average + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ID, average, email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(ID, other.ID)
				&& Double.doubleToLongBits(average) == Double.doubleToLongBits(other.average)
				&& Objects.equals(email, other.email);
	}

}
