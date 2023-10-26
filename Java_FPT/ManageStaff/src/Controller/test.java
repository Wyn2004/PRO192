package Controller;

import View.StaffManagement;
import View.Menu;

public class test {
	public static void main(String[] args) {

		String[] options = { "Display all staff", "Search staff", "Login", "Change password", "Exit." };
		Menu mainMenu = new StaffManagement("Staff Management", options);
		mainMenu.execute();

	}
}
