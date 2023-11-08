package module;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import control.ListLector;
import utils.Validator;

public class Lector extends Person {

	private String ID;
	private String email;
	private String subject;

	public Lector() {
	}

	public Lector(String ID) {
		this.ID = ID;
	}

	public Lector(String name, String gender, Date birthDay, String adress, String phoneNum, String ID, String email,
			String subject) {
		super(name, gender, birthDay, adress, phoneNum);
		this.ID = ID;
		this.email = email;
		this.subject = subject;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public void inputInfo() {

		super.inputInfo();
		String mess = "Enter lector ID: ";
		while (true) {
			this.ID = Validator.inputString(mess).toUpperCase();
			if (!ListLector.checkID(this.ID)) {
				break;
			} else
				mess = "Invalid input (this ID is exist), please enter again: ";
		}

		mess = "Enter lector email: ";
		while (true) {
			this.email = Validator.inputEmail(mess);
			if (!ListLector.checkEmail(this.email)) {
				break;
			} else
				mess = "Invalid input (this email is exist), please enter again: ";
		}
		this.subject = Validator.inputString("Enter subject: ").toUpperCase();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lector other = (Lector) obj;
		return Objects.equals(ID, other.ID) && Objects.equals(email, other.email)
				&& Objects.equals(subject, other.subject);
	}

	@Override
	public String toString() {
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");

		return "Lector [name=" + getName() + ", gender=" + getGender() + ", birthDay="
				+ formatDate.format(getBirthDay()) + ", adress=" + getAdress() + ", phoneNum=" + getPhoneNum() + ", ID="
				+ ID + ", email=" + email + ", subject=" + subject + "]";
	}

}
