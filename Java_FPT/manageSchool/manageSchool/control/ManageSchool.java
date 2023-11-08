package control;

import view.Menu;

public class ManageSchool extends Menu {

	private ListStudent listStudent = new ListStudent();

	private ListLector listLector = new ListLector();

	public ManageSchool() {
	}

	public ManageSchool(String nameMenu, String[] options) {
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
				String[] studentOptions = { "Print list students.", "Add a student.", "Edit.",
						"Remove all students in list.", "Remove student by ID.", "Remove by email.",
						"Find Student by ID.", "Find student by name.", "Find by email.", "Find by major.",
						"Print all students have scholarship.", "Sort list student by name.",
						"Sort list student by average.", "Load data from file", "Save data to file", "Back." };
				Menu menuStudents = new MenuStudents("Manage Student", studentOptions, listStudent);
				menuStudents.execute();
				System.out.println();
				break;
			}
			case 2: {
				String[] lectorOptions = { "Print list lector.", "Add a lector.", "Edit.", "Remove all lector in list.",
						"Remove lector by ID.", "Remove by email.", "Find lector by ID.", "Find lector by name.",
						"Find by email", "Find by major.", "Sort list lector by name.", "Load data from file",
						"Save data to file", "Back." };
				if (listLector == null)
					listLector = new ListLector();
				Menu menuLectors = new MenuLector("Manage Lector", lectorOptions, listLector);
				menuLectors.execute();
				System.out.println();
				break;

			}
			}
		} while (choice != 0);
	}

}
