package module;

import java.io.Serializable;
import java.util.Scanner;

import com.google.gson.annotations.Expose;

public class Person implements Serializable{
	
	@Expose
	private String name;
	@Expose
	private String gender;
	@Expose
	private Day birthDay = new Day();
	@Expose
	private String adress;

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, String gender, Day birthDay, String adress) {
		this.name = name;
		this.gender = gender;
		this.birthDay = birthDay;
		this.adress = adress;
	}

	public void inputInfo() {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter name: ");
		while(!setName(scanner.nextLine().trim()));
		System.out.print("Enter gender: ");
		while(!setGender(scanner.nextLine().trim()));
		birthDay.inputBirth();
		System.out.print("Enter adress: ");
		while(!setAdress(scanner.nextLine().trim()));

	}

	public void showInfo() {
		System.out.print(toStringPerson());
	}

	public String getName() {
		return name;
	}

	public boolean setName(String name) {
		if (name!=null && name.length()>0) {
			this.name = name;
			return true;
		} else {
			System.err.print("Error... Invalid input please try again:");
			return false;
		}
	}

	public String getGender() {
		return gender;
	}

	public boolean setGender(String gender) {
		if (gender!=null && gender.length()>0) {
			this.gender = gender.toUpperCase();
			return true;
		} else {
			System.err.print("Error... Invalid input please try again:");
			return false;
		}
	}

	public Day getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Day birthDay) {
		this.birthDay = birthDay;
	}

	public String getAdress() {
		return adress;
	}

	public boolean setAdress(String adress) {
		if (adress!=null && adress.length()>0) {
			this.adress = adress.toUpperCase();
			return true;
		} else {
			System.err.print("Error... Invalid input please try again:");
			return false;
		}	}

	public String toStringPerson() {
		return "Person: [name=" + name + ", gender=" + gender + ", birthDay=" + birthDay + ", adress=" + adress + "]";
	}

}
