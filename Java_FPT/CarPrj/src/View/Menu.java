package View;

import java.util.List;

import Module.Brand;
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
		System.out.println("-------------------------------------------------------");
		for (int i = 0; i < options.length - 1; i++)
			System.out.println((i + 1) + ". " + options[i]);
		System.out.println("0. " + options[options.length - 1]);
		System.out.println("-------------------------------------------------------");
		return validator.inputInt("Enter your choice: ", 0, options.length - 1);
	}
	
	
	public abstract void execute();
}
