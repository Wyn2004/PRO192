package Controller;

import View.MainMenu;
import View.Menu;

public class test {
	public static void main(String[] args) {
		
		String[] options = {"List all brands.", "Add a new brand", "Search a brand based on its ID.",
				"Update a brand.", "Save brands to the file, named brands.txt.",
				"List all cars in ascending order of brand names.", "List cars based on a part of an input brand name.",
				"Add a car.", "Remove a car based on its ID.", "Update a car based on its ID.",
				"Save cars to file, named cars.txt.", "Exit."};
		Menu mainMenu = new MainMenu("Magenement Car.",options);
		mainMenu.execute();

	}
}
