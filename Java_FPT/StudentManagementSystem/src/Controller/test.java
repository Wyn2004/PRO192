package Controller;

import View.MainMenu;
import View.Menu;

public class test {
	public static void main(String[] args) {

		String[] options = { "Add new student", "Search student", "Print all student", "Exit" };
		Menu mainMenu = new MainMenu("Student Magenement System", options);
		mainMenu.execute();

	}
}
