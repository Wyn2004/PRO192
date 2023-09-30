package module;

import java.util.Objects;
import java.util.Scanner;

public class Lector extends Person {

	private String ID;
	private String email;

	public Lector() {
	}

	public Lector(String ID) {
		this.ID = ID;
	}

	public Lector(String name, String gender, Day birthDay, String adress, String ID, String email) {
		super(name, gender, birthDay, adress);
		this.ID = ID;
		this.email = email;
	}

	@Override
	public void inputInfo() {
		super.inputInfo();
		@SuppressWarnings("resource")
		Scanner inputLector = new Scanner(System.in);
		System.out.print("Enter lector ID (8 character): ");
		while (!setID(inputLector.nextLine()));
		System.out.print("Enter email: ");
		while (!setEmail(inputLector.nextLine()))
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
			this.ID = ID;
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

	public String toStringLector() {
		return " Lector: [ID=" + ID + ", email=" + email + "]";
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
