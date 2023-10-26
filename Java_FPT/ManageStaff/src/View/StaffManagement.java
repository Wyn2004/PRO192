package View;

import Module.Staff;
import Module.StaffList;
import Module.Validator;

public class StaffManagement extends Menu {

	private Validator validator = new Validator();

	public StaffManagement() {
	}

	public StaffManagement(String nameMenu, String[] options) {
		super(nameMenu, options);
	}

	@Override
	public void execute() {
		int choice;
		String loginID = "";
		StaffList staffList = super.getStaffList();

		do {
			choice = displayMenu();
			System.out.println();
			switch (choice) {
			case 0: {
				System.out.println("Good bye!!!!");
				break;
			}
			case 1: {
				staffList.displayListStaff();
				System.out.println();
				break;
			}
			case 2: {
				String optionSearch[] = { "Search by name", "SearchStaff by department", "Search by ID", "Back" };
				SearchStaff searchStaff = new SearchStaff("Search Staff ", optionSearch);
				searchStaff.execute();
				System.out.println();
				break;

			}
			case 3: {
				if (!staffList.getListStaff().isEmpty()) {
					String ID = validator.inputString("Enter staff ID: ");
					String password = validator.inputString("Enter password: ");
					if (staffList.login(ID, password)) {
						System.out.println("Login successfully!!!");
						loginID = ID;
					} else
						System.err.println("Login failed!!!");
				} else
					System.err.println("List staff is empty!!");
				System.out.println();
				break;
			}
			case 4: {
				if (loginID != "") {
					String oldPassword = validator.inputString("Enter old password: ");
					String newPassWord = validator.inputString("Enter new password: ");
					Staff changePassStaff = staffList.searchByID(loginID);
					changePassStaff.changePassword(oldPassword, newPassWord);
				} else
					System.err.println("Please login first in selection 3 !!!");
				System.out.println();
				break;
			}
			}
		} while (choice != 0);
	}

}