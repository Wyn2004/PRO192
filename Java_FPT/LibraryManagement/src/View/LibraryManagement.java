package View;

import Module.Library;
import Module.Validator;

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
					Menu menuSearch = new Menu("Searching book",Options) {
						
						@SuppressWarnings("deprecation")
						@Override
						public void execute() {
							int choice;
							do {
								choice = displayMenu();
								System.out.println();
								switch (choice) {
								case 1: {
									String bookID = Validator.inputString("Enter book id you want search: ");
									library.searchBook(p -> p.getBookID().equalsIgnoreCase(bookID));
									System.out.println();
									break;
								}
								case 2: {
									String title = Validator.inputString("Enter title you want search: ");
									library.searchBook(p -> p.getBookTitle().contains(title));
									System.out.println();
									break;

								}
								case 3: {
									String author = Validator.inputString("Enter author you want search: ");
									library.searchBook(p -> p.getAuthor().contains(author));
									System.out.println();
									break;
								}
								case 4: {
									int yearPublic = Validator.inputInt("Enter year public you want search: ",1,Integer.MAX_VALUE);
									library.searchBook(p -> ((p.getDatePublic().getYear()+1900)) == yearPublic);
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
					};
					menuSearch.execute();
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