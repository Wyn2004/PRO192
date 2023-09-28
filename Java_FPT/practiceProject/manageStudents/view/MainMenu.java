package view;

import module.ListLector;
import module.ListStudent;

public class MainMenu extends Menu {
	ListStudent listStudent = new ListStudent();
	ListLector listLector = new ListLector();

	public MainMenu() {
	}

	public MainMenu(String nameMenu, String[] options) {
		super(nameMenu, options);
	}

	@Override
	public void execute() {
		int choice;

		do {
			choice = displayMenu();
			System.out.println();
			switch (choice) {
			case 0: {
				System.out.println("Good bye!!!!");
				break;
			}
			case 1: {
				String[] studentOptions = { "Print list students.", "Add a student.", "Check list student is empty.",
						"Get size of list Student.", "Remove all students in list.", "Remove student by ID.",
						"Find Student by ID.", "Find student by name.", "Print all students have scholarship.",
						"Sort list student by name.", "Sort list student by average.", "Back." };
				Menu menuStudents = new MenuStudents("Manage Student", studentOptions, listStudent);
				menuStudents.execute();
				System.out.println();
				break;
			}
			case 2: {
				String[] lectorOptions = { "Print list lector.", "Add a lector.", "Check list lector is empty.",
						"Get size of list lector.", "Remove all lector in list.", "Remove lector by ID.",
						"Find lector by ID.", "Find lector by name.", "Sort list lector by name.", "Back." };
				Menu menuLectors = new MenuLector("Manage Lector", lectorOptions, listLector);
				menuLectors.execute();
				System.out.println();
				break;

			}
			}
		} while (choice != 0);
	}

}
