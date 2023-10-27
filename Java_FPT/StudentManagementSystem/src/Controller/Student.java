package Controller;

public class Student implements Comparable<Student>{

	private String studentID;
	private String firstName;
	private String lastName;
	private String dob;
	private String gender;

	public Student(String studentID, String firstName, String lastName, String dob, String gender) {
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String toString() {
		return studentID + ", " + firstName + ", " + lastName + ", " + dob + ", " + gender;
	}

	@Override
	public int compareTo(Student o) {
		return lastName.compareTo(o.getLastName());
	}
	
}
