package Module;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student implements Comparable<Student>{

	private String studentID;
	private String firstName;
	private String lastName;
	private Date dob;
	private String gender;

	public Student(String studentID, String firstName, String lastName, Date dob, String gender) {
		this.studentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
	}

	public Student() {

	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String toString() {
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		return studentID + ", " + firstName + ", " + lastName + ", " + formatDate.format(dob) + ", " + gender;
	}

	@Override
	public int compareTo(Student o) {
		return lastName.compareTo(o.getLastName());
	}
	
}
