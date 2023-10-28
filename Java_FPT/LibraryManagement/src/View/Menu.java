package View;

import Module.Library;
import Module.Validator;

public abstract class Menu {

	private String menuName;
	private String[] options;
	private Library library = new Library();

	public Menu() {
		
	}

	public Menu(String menuName, String[] options) {

		this.menuName = menuName;
		this.options = options;

	}
	
	public Library getLib()	{
		return this.library;
	}

	public int displayMenu() {

		System.out.println(menuName);
		System.out.println("-------------------------------------------");
		for (int i = 0; i < options.length; i++)
			System.out.println((i + 1) + ". " + options[i]);
		System.out.println("-------------------------------------------");
		return Validator.inputInt("Enter selection: ", 1, options.length);
	}

	public abstract void execute();

}
