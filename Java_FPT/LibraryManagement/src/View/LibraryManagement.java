package View;

import Module.Library;

public class LibraryManagement extends Menu {

	public LibraryManagement() {
	}

	public LibraryManagement(String nameMenu, String[] options) {
		super(nameMenu, options);
	}

	@Override
	public void execute() {
		int choice;
		Library library = getLib();
		do {
			choice = displayMenu();
			System.out.println();
			switch (choice) {
			case 1: {
				library.displayLibrary(library.getListBook());
				System.out.println();
				break;
			}
			case 2: {
				if (!library.getListBook().isEmpty()) {
					String[] Options = { "Find by BookID", "Find by Title", "Find by author",
							"Find by Year of publishing", "Back." };
					SearchMenu searchMenu = new SearchMenu("Book Searching", Options, library);
					searchMenu.execute();
				} else
					System.err.println("This library is empty !!!");
				System.out.println();
				break;
			}
			case 3: {
				library.add();
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