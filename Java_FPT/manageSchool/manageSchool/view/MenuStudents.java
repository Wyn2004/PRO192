package view;

import module.ListStudent;
import module.Student;
import module.Validator;

public class MenuStudents extends Menu {

	private ListStudent listStudent;
	private Validator validator = new Validator();

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
				System.out.println("Backed main menu !!!");
				System.out.println();
				break;
			}
			case 1: {
				listStudent.printListStudents();
				break;
			}
			case 2: {
				Student student = new Student();
				student.inputInfo();
				listStudent.add(student);
				break;
			}
			case 3: {
				System.out.println("List student is empty: " + listStudent.isEmpty());
				System.out.println();
				break;
			}
			case 4: {
				System.out.println("Number student in list: " + listStudent.getSize());
				System.out.println();
				break;
			}
			case 5: {
				int edit = 0;
				if (listStudent.isEmpty())
					System.err.println(" List is empty!!!");
				else
					do {
						listStudent.printListStudents();
						System.err.println("You just only edit phone number!!!");
						System.out.println("1. Edit.");
						System.out.println("0. Exit.");
						edit = validator.inputInt("Enter your choice: ", 0, 1);
						if (edit == 1) {
							String ID = validator.inputID("Enter ID student you want edit: ");
							Student studentEdit = new Student(ID);
							if (listStudent.findByID(studentEdit)) {

								String phoneNew = validator.inputPhoneNum("Enter new phone number: ");
								if (listStudent.edit(ID, phoneNew))
									System.out.println("Done!!!");
								System.out.println();
							} else {
								System.err.println("Student with ID: " + studentEdit.getID() + " isn't exist!!!");
								System.out.println();
							}
						}
					} while (edit != 0);
				System.out.println();
				break;
			}
			case 6: {
				listStudent.removeAll();
				System.out.println();
				break;
			}
			case 7: {
				Student studentID = new Student(validator.inputID("Enter your ID you want remove: "));
				listStudent.removeByID(studentID);
				break;
			}
			case 8: {
				String email = validator.inputEmail("Enter your email you want remove: ");
				listStudent.removeByEmail(email);
				System.out.println();
				break;
			}
			case 9: {
				Student studentID = new Student(validator.inputID("Enter your ID you want check: "));
				if (!listStudent.findByID(studentID))
					System.err.println("Student with ID: " + studentID.getID() + " isn't exist!!!");
				System.out.println();
				break;
			}
			case 10: {
				String name = validator.inputString("Enter name you want search: ");
				if (!listStudent.findByName(name))
					System.err.println("Student with name " + name + " isn't exist!!!");
				System.out.println();
				break;
			}
			case 11: {
				String email = validator.inputEmail("Enter email you want search: ");
				if (!listStudent.findByEmail(email))
					System.err.println("Student with email " + email + " isn't exist!!!");
				System.out.println();
				break;
			}
			case 12: {
				String major = validator.inputString("Enter major you want search: ");
				if (!listStudent.findByMajor(major))
					System.err.println("Student with major " + major + " isn't exist!!!");
				System.out.println();
			}
			case 13: {
				listStudent.printScholarShip();
				System.out.println();
				break;
			}
			case 14: {
				listStudent.sortByName();
				System.out.println();
				break;
			}
			case 15: {
				listStudent.sortByAverage();
				System.out.println();
				break;
			}
			}
		} while (choice != 0);
	}

}
