package module;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import control.ListStudent;
import utils.Validator;

public class Student extends Person {

	private String ID;
	private double average;
	private String email;
	private String major;

	public Student() {
	}

	public Student(String ID) {
		this.ID = ID;
	}

	public Student(String name, String gender, Date birthDay, String adress, String phoneNum, String ID, double average,
			String email, String major) {
		super(name, gender, birthDay, adress, phoneNum);
		this.ID = ID;
		this.average = average;
		this.email = email;
		this.major = major;
	}

	@Override
	public void inputInfo() {

		super.inputInfo();
		String mess = "Enter student ID: ";
		while (true) {
			this.ID = Validator.inputString(mess).toUpperCase();
			if (!ListStudent.checkID(this.ID)) {
				break;
			} else
				mess = "Invalid input (this ID is exist), please enter again: ";
		}
		this.average = Validator.inputDouble("Enter average: ", 0, 10);
		mess = "Enter student email: ";
		while (true) {
			this.email = Validator.inputEmail("Enter email: ");
			if (!ListStudent.checkEmail(this.email)) {
				break;
			} else
				mess = "Invalid input (this email is exist), please enter again: ";
		}		this.major = Validator.inputString("Enter major: ").toUpperCase();

		System.out.println();
	}

	public void showInfo() {
		System.out.println(toStringStudent());
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(ID, other.ID)
				&& Double.doubleToLongBits(average) == Double.doubleToLongBits(other.average)
				&& Objects.equals(email, other.email) && Objects.equals(major, other.major);
	}

	public String toStringStudent() {
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		return "Student [name=" + getName() + ", gender=" + getGender() + ", birthDay="
				+ formatDate.format(getBirthDay()) + ", adress=" + getAdress() + ", phoneNum=" + getPhoneNum() + ", ID="
				+ ID + ", average=" + average + ", email=" + email + ", major=" + major + "]";
	}

}
