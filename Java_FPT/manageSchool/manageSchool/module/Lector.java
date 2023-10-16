package module;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

import com.google.gson.annotations.Expose;

public class Lector extends Person implements Serializable {

	@Expose
	private String ID;
	@Expose
	private String email;
	@Expose
	private String subject;

	public Lector() {
	}

	public Lector(String ID) {
		this.ID = ID;
	}

	public Lector(String name, String gender, Day birthDay, String adress, String phoneNum, String ID, String email,
			String subject) {
		super(name, gender, birthDay, adress, phoneNum);
		this.ID = ID;
		this.email = email;
		this.subject = subject;
	}

	@Override
	public void inputInfo() {
		super.inputInfo();
		@SuppressWarnings("resource")
		Scanner inputLector = new Scanner(System.in);
		System.out.print("Enter lector ID (8 character): ");
		while (!setID(inputLector.nextLine().trim()))
			;
		System.out.print("Enter email: ");
		while (!setEmail(inputLector.nextLine().trim()))
			;
		System.out.print("Enter subject: ");
		while (!setSubject(inputLector.nextLine().trim()))
			;
	}

	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println(toStringLector());
	}

	public String getID() {
		return ID;
	}

	public boolean setID(String ID) {
		if (ID != null && ID.length() == 8) {
			this.ID = ID.toUpperCase();
			return true;
		}
		System.err.print("Error... Enter again Student ID (8 character): ");
		return false;
	}

	public String getEmail() {
		return email;
	}

	public boolean setEmail(String email) {
		if (email != null && email.contains("@") && !email.contains(" ")) {
			this.email = email;
			return true;
		}
		System.err.print("Error... Enter again email (contain '@'): ");
		return false;
	}

	public String getSubject() {
		return subject;
	}

	public boolean setSubject(String subject) {
		if (subject != null && subject.length() > 0) {
			this.subject = subject.toUpperCase();
			return true;
		} else {
			System.err.print("Error... Enter again subject: ");
			return false;
		}
	}

	public String toStringLector() {
		return "Lector [ID=" + ID + ", email=" + email + ", subject=" + subject + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ID, email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lector other = (Lector) obj;
		return Objects.equals(ID, other.ID) && Objects.equals(email, other.email);
	}

}
