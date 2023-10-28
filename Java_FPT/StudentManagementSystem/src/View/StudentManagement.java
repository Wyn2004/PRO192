package View;

import java.util.Date;

import Module.StudentList;
import Module.Validator;

public class StudentManagement extends Menu {

	public StudentManagement() {
	}

	public StudentManagement(String nameMenu, String[] options) {
		super(nameMenu, options);
	}

	@Override
	public void execute() {
		int choice;
		StudentList studentList = super.getStudentList();
		do {
			choice = displayMenu();
			System.out.println();
			switch (choice) {
			case 1: {
				studentList.add();
				System.out.println("Succesfully!!!");
				System.out.println();
				break;
			}
			case 2: {
				if (!studentList.getList().isEmpty()) {
					String[] Options_1 = { "Search By ID", "Search By Last Name ", "Search By DOB", "Search By Gender",
							"Return" };
					Menu menuSearch = new Menu("Student Searching", Options_1) {

						@Override
						public void execute() {
							int choice;
							do {
								choice = displayMenu();
								System.out.println();
								switch (choice) {
								case 1: {
									String ID = Validator.inputString("Enter ID you want search: ");
									studentList.seachStudent(p -> (p.getStudentID().equalsIgnoreCase(ID)));
									break;
								}
								case 2: {
									String lastName = Validator.inputString("Enter last name you want search: ");
									studentList.seachStudent(p -> (p.getLastName().equalsIgnoreCase(lastName)));
									break;
								}
								case 3: {
									Date DOB = Validator
											.inputDate("Enter date of birth (dd/MM/yyyy) you want search: ");
									studentList.seachStudent(p -> (p.getDob().equals(DOB)));

									break;
								}
								case 4: {
									String gender = Validator
											.inputString("Enter gender (male/female) you want search: ");
									studentList.seachStudent(p -> (p.getGender().equalsIgnoreCase(gender)));
									break;
								}
								case 5: {
									System.out.println("Back to Student Magenement System !!!");
									break;
								}
								}
							} while (choice != 5);
						}
					};
					menuSearch.execute();
				} else
					System.err.println("List student is empty!!!");
				System.out.println();
				break;

			}
			case 3: {
				studentList.displayListStudent(studentList.getList());
				System.out.println();
				break;
			}
			case 4: {
				System.out.println("Good bye!!!!");
				break;
			}
			}
		} while (choice != 4);
	}

}