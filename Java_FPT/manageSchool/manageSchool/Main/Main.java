package Main;

import control.ManageSchool;
import view.Menu;

public class Main {
	public static void main(String[] args) {

		String[] options = { "Management Student.", "Management Lector.", "Display all data.", "Exit." };
		Menu mainMenu = new ManageSchool("Magenement School", options);
		mainMenu.execute();

	}
}
