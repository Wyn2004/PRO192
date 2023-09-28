package module;

import java.util.Scanner;

public class Person {

	private String name;
	private String gender;
	private Day birthDay = new Day();
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
		this.name = scanner.nextLine();
		System.out.print("Enter gender: ");
		this.gender = scanner.nextLine();
		birthDay.inputBirth();
		System.out.print("Enter adress: ");
		this.adress = scanner.nextLine();

	}

	public void showInfo() {
		System.out.print(toStringPerson());
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

	public Day getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Day birthDay) {
		this.birthDay = birthDay;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String toStringPerson() {
		return "Person: [name=" + name + ", gender=" + gender + ", birthDay=" + birthDay + ", adress=" + adress + "]";
	}

}
