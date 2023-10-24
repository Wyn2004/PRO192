package Controller;

import View.MainMenu;
import View.Menu;

public class test {
	public static void main(String[] args) {
		
		String[] options = {"Option 1.", "Option 2.","Save File", "Read File", "Exit."};
		Menu mainMenu = new MainMenu("Magenement ....",options);
		mainMenu.execute();

	}
}
