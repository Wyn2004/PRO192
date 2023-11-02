package View;

import Module.StaffList;
import Module.Validator;

public abstract class Menu {

	private String menuName;
	private String[] options;
	private StaffList staffList = new StaffList();

	public Menu() {
		
	}

	public Menu(String menuName, String[] options) {

		this.menuName = menuName;
		this.options = options;

	}
	
	public StaffList getStaffList()	{
		return this.staffList;
	}

	public int displayMenu() {

		System.out.println(menuName);
		System.out.println("-------------------------------------------");
		for (int i = 0; i < options.length - 1; i++)
			System.out.println((i + 1) + ". " + options[i]);
		System.out.println("0. " + options[options.length - 1]);
		System.out.println("-------------------------------------------");
		return Validator.inputInt("Enter selection: ", 0, options.length - 1);
	}

	public abstract void execute();

}
