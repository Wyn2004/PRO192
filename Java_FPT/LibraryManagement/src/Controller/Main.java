package Controller;

import View.LibraryManagement;
import View.Menu;

public class Main {
	public static void main(String[] args) {
		
		String[] options = {"List all book.", "Search book","Add new book", "Exit"};
		Menu mainMenu = new LibraryManagement("Library Magenement",options);
		mainMenu.execute();

	}
}
