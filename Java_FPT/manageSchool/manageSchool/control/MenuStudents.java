package control;

import java.io.IOException;

import utils.Validator;
import view.Menu;

public class MenuStudents extends Menu {

	private ListStudent listStudent;

	public MenuStudents() {
	}

	public MenuStudents(String notification, String[] options, ListStudent listStudent) {
		super(notification, options);
		this.listStudent = listStudent;
	}

	@Override
	public void execute() {
		int choice;

		do {
			choice = displayMenu();
			System.out.println();
			switch (choice) {
			case 0: {
				System.out.println("Backed Management School !!!");
				System.out.println();
				break;
			}
			case 1: {
				listStudent.printListStudents(listStudent.getList());
				break;
			}
			case 2: {
				listStudent.add();
				break;
			}
			case 3: {
				int edit = 0;
				if (listStudent.getList().isEmpty())
					System.err.println(" List is empty!!!");
				else
					do {
						listStudent.printListStudents(listStudent.getList());
						System.err.println("You just only edit phone number!!!");
						System.out.println("1. Edit.");
						System.out.println("0. Exit.");
						edit = Validator.inputInt("Enter your choice: ", 0, 1);
						if (edit == 1) {
							String ID = Validator.inputString("Enter ID student you want edit: ").toUpperCase();
							if (ListStudent.checkID(ID)) {
								String phoneNew = Validator.inputPhoneNum("Enter new phone number: ");
								if (listStudent.edit(ID, phoneNew))
									System.out.println("Done!!!");
								System.out.println();
							} else {
								System.err.println("Student with ID: " + ID + " isn't exist!!!");
								System.out.println();
							}
						}
					} while (edit != 0);
				System.out.println();
				break;
			}
			case 4: {
				listStudent.removeAll();
				System.out.println();
				break;
			}
			case 5: {
				String id = Validator.inputString("Enter your ID you want remove: ").toUpperCase();
				listStudent.removeStudent(p -> p.getID().equalsIgnoreCase(id));
				break;
			}
			case 6: {
				String email = Validator.inputEmail("Enter your email you want remove: ");
				listStudent.removeStudent(p -> p.getEmail().equals(email));
				System.out.println();
				break;
			}
			case 7: {
				String id = Validator.inputString("Enter your ID you want check: ").toUpperCase();
				listStudent.searchStudent(p -> p.getID().equalsIgnoreCase(id));
				System.out.println();
				break;
			}
			case 8: {
				String name = Validator.inputString("Enter name you want search: ");
				listStudent.searchStudent(p -> p.getName().contains(name));
				System.out.println();
				break;
			}
			case 9: {
				String email = Validator.inputEmail("Enter email you want search: ");
				listStudent.searchStudent(p -> p.getEmail().equals(email));
				System.out.println();
				break;
			}
			case 10: {
				String major = Validator.inputString("Enter major you want search: ").toUpperCase();
				listStudent.searchStudent(p -> p.getMajor().equalsIgnoreCase(major));
				System.out.println();
				break;
			}
			case 11: {
				listStudent.printScholarShip();
				System.out.println();
				break;
			}
			case 12: {
				listStudent.sortByName();
				System.out.println();
				break;
			}
			case 13: {
				listStudent.sortByAverage();
				System.out.println();
				break;
			}
			case 14:	{
				try {
					listStudent.readFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
			case 15:	{
				try {
					listStudent.writeFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
			}
		} while (choice != 0);
	}

}
