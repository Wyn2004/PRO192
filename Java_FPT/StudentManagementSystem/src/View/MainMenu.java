package View;

import Controller.StudentList;

public class MainMenu extends Menu {

	public MainMenu() {
	}

	public MainMenu(String nameMenu, String[] options) {
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
					Menu searchMenu = new SearchStudent("Student searching", Options_1, studentList);
					searchMenu.execute();
				} else
					System.err.println("List student is empty!!!");
				System.out.println();
				break;

			}
			case 3: {
				studentList.displayListStudent();
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