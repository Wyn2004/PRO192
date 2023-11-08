package module;

import java.util.Date;
import java.util.Objects;

public class Person {

	private String name;
	private String gender;
	private Date birthDay;
	private String adress;
	private String phoneNum;

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, String gender, Date birthDay, String adress, String phoneNum) {
		this.name = name;
		this.gender = gender;
		this.birthDay = birthDay;
		this.adress = adress;
		this.phoneNum = phoneNum;
	}

	public void inputInfo() {

		this.name = utils.Validator.inputString("Enter name: ");
		this.gender = utils.Validator.inputString("Enter gender: ");
		this.birthDay = utils.Validator.inputDate("Enter birthDay (dd/MM/yyyy): ");
		this.adress = utils.Validator.inputString("Enter adress: ");
		this.phoneNum = utils.Validator.inputPhoneNum("Enter phone number: ");

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(adress, other.adress) && Objects.equals(birthDay, other.birthDay)
				&& Objects.equals(gender, other.gender) && Objects.equals(name, other.name)
				&& Objects.equals(phoneNum, other.phoneNum);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + ", birthDay=" + birthDay + ", adress=" + adress
				+ ", phoneNum=" + phoneNum + "]";
	}
}
