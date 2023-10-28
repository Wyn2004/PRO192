package View;

import Module.Staff;
import Module.StaffList;
import Module.Validator;

public class StaffManagement extends Menu {

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
				staffList.displayListStaff(staffList.getListStaff());
				System.out.println();
				break;
			}
			case 2: {
				if (!staffList.getListStaff().isEmpty()) {
					String optionSearch[] = { "Search by name", "SearchStaff by department", "Search by ID", "Back" };
					Menu menuSearch = new Menu("Searching Staff", optionSearch) {

						@Override
						public void execute() {
							int choice;
							StaffList staffList = super.getStaffList();
							do {
								choice = displayMenu();
								System.out.println();
								switch (choice) {
								case 0: {
									System.out.println("Back to management staff!!!!");
									break;
								}
								case 1: {
									String name = Validator.inputString("Enter name: ");
									staffList.searchStaff(p -> (p.getFullName().contains(name)));
									System.out.println();
									break;
								}
								case 2: {
									String department = Validator.inputString("Enter department: ");
									staffList.searchStaff(p -> (p.getDepartment().equals(department)));
									break;

								}
								case 3: {
									String id = Validator.inputString("Enter ID: ");
									staffList.searchStaff(p -> (p.getStaffID().equalsIgnoreCase(id)));
									break;
								}
								}
							} while (choice != 0);
						}
					};
					menuSearch.execute();
				} else
					System.err.println("List staff is empty!!");
				System.out.println();
				break;

			}
			case 3: {
				if (!staffList.getListStaff().isEmpty()) {
					String ID = Validator.inputString("Enter staff ID: ").toUpperCase();
					String password = Validator.inputString("Enter password: ");
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
					String oldPassword = Validator.inputString("Enter old password: ");
					String newPassWord = Validator.inputString("Enter new password: ");
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