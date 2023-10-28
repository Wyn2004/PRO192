package View;

import Module.Validator;

public abstract class Menu {

	private String menuName;
	private String[] options;
	private Validator validator = new Validator();

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
		return validator.inputInt("Enter selection: ", 1, options.length);
	}

	public abstract void execute();

}
