package View;

import Controller.StudentList;
import Module.Validator;

public class SearchStudent extends Menu {

	private StudentList studentList;
	private Validator validator = new Validator();

	public SearchStudent() {

	}

	public SearchStudent(String menuName, String[] options, StudentList list) {
		super(menuName, options);
		this.studentList =list;
	}

	@Override
	public void execute() {
		int choice;
		do {
			choice = displayMenu();
			System.out.println();
			switch (choice) {
			case 1: {
				if (!studentList.getList().isEmpty()) {
					String ID = validator.inputString("Enter ID you want search: ");
					studentList.searchID(ID);
				} else
					System.err.println("List student is empty!!!");
				break;
			}
			case 2: {
				if (!studentList.getList().isEmpty()) {
					String lastName = validator.inputString("Enter last name you want search: ");
					studentList.searchLastName(lastName);
				} else
					System.err.println("List student is empty!!!");
				break;
			}
			case 3: {
				if (!studentList.getList().isEmpty()) {
					String DOB = validator.inputString("Enter date of birth (dd/MM/yyyy) you want search: ");
					studentList.searchDOB(DOB);
				} else
					System.err.println("List student is empty!!!");
				break;
			}
			case 4: {
				if (!studentList.getList().isEmpty()) {
					String gender = validator.inputString("Enter gender you want search: ");
					studentList.searchGender(gender);
				} else
					System.err.println("List student is empty!!!");
				break;
			}
			case 5: {
				System.out.println("Back to Student Magenement System !!!");
				break;
			}
			}
		} while (choice != 5);
	}

}
