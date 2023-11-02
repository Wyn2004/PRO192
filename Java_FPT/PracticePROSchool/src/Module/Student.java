package Module;

import java.util.Objects;

public class Student {

	private String ID;
	private String firstName;
	private String lastName;
	private String phoneNum;
	private String adress;
	
	public Student(String iD, String firstName, String lastName, String phoneNum, String adress) {
		this.ID = iD;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.adress = adress;
	}
	
	public Student() {

	}
	
	public String getID() {
		return ID;
	}
	
	public void setID(String iD) {
		ID = iD;
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
	
	public String getPhoneNum() {
		return phoneNum;
	}
	
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public String getAdress() {
		return adress;
	}
	
	public void setAdress(String adress) {
		this.adress = adress;
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
		return Objects.equals(ID, other.ID) && Objects.equals(adress, other.adress)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(phoneNum, other.phoneNum);
	}

	@Override
	public String toString() {
		return "Student{ID=" + ID + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNum=" + phoneNum
				+ ", adress=" + adress + "}";
	}
	
}
