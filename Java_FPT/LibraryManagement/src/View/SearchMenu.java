package View;

import Module.Library;
import Module.Validator;

public class SearchMenu extends Menu {

	private Library library;
	private Validator validator = new Validator();

	public SearchMenu() {

	}

	public SearchMenu(String menuName, String[] options, Library library) {
		super(menuName, options);
		this.library = library;
	}

	@Override
	public void execute() {
		int choice;
		do {
			choice = displayMenu();
			System.out.println();
			switch (choice) {
			case 1: {
				String bookID = validator.inputString("Enter book id you want search: ");
				library.searchByID(bookID);
				System.out.println();
				break;
			}
			case 2: {
				String title = validator.inputString("Enter title you want search: ");
				library.searchByTitle(title);
				System.out.println();
				break;

			}
			case 3: {
				String author = validator.inputString("Enter author you want search: ");
				library.searchByAuthor(author);
				System.out.println();
				break;
			}
			case 4: {
				int yearPublic = validator.inputInt("Enter year public you want search: ",1,Integer.MAX_VALUE);
				library.searchByDatePublic(yearPublic);
				System.out.println();
				break;
			}
			case 5: {
				System.out.println("Back to Management Library !!!");
				break;
			}
			}
		} while (choice != 5);
	}

}
