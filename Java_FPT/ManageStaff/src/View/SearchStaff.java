package View;

import Module.StaffList;
import Module.Validator;

public class SearchStaff extends Menu {

	private Validator validator = new Validator();

	public SearchStaff() {

	}

	public SearchStaff(String menuName, String[] options) {
		super(menuName, options);
	}

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
				String name = validator.inputString("Enter name: ");
				staffList.searchByName(name);
				System.out.println();
				break;
			}
			case 2: {
				String department = validator.inputString("Enter department: ");
				staffList.searchByDepartment(department);
				break;

			}
			case 3: {
				String id = validator.inputString("Enter ID: ");
				if (staffList.searchByID(id)!= null)	{
					System.out.println(staffList.searchByID(id).toString());
				}
				break;
			}
			}
		} while (choice != 0);
	}

}
