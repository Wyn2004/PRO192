package control;

import view.MainMenu;
import view.Menu;

public class testStudents {
	public static void main(String[] args) {
		
		String[] options = {"Management Student.", "Management Lector.","Save File", "Read File", "Exit."};
		Menu mainMenu = new MainMenu("Magenement School",options);
		mainMenu.execute();

	}
}
