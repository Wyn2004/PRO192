package View;

import Util.Inputter;

public abstract class Menu {

	private String menuName;
	private String[] options;

	public Menu() {
		
	}

	public Menu(String menuName, String[] options) {

		this.menuName = menuName;
		this.options = options;

	}

	public int displayMenu() {

		System.out.println(menuName);
		System.out.println("-------------------------------------------");
		for (int i = 0; i < options.length; i++)
			System.out.println((i + 1) + ". " + options[i]);
		System.out.println("-------------------------------------------");
		return Inputter.inputInt("Enter selection: ", 1, options.length);
	}

	public abstract void execute();

}
