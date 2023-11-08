package control;

import java.io.IOException;

import utils.Validator;
import view.Menu;

public class MenuLector extends Menu {

	ListLector listLector;

	public MenuLector() {
	}

	public MenuLector(String notification, String[] opStrings, ListLector listLector) {
		super(notification, opStrings);
		this.listLector = listLector;
	}

	@Override
	public void execute() {
		int choice;

		do {

			choice = displayMenu();
			System.out.println();
			switch (choice) {
			case 0: {
				System.out.println("Backed Manage School !!!");
				System.out.println();
				break;
			}
			case 1: {
				listLector.printListLector(listLector.getList());
				break;
			}
			case 2: {
				listLector.add();
				break;
			}
			case 3: {
				int edit = 0;
				if (listLector.getList().isEmpty())
					System.err.println("List is empty!!!");
				else
					do {
						listLector.printListLector(listLector.getList());
						System.err.println("You just only edit phone number!!!");
						System.out.println("1. Edit.");
						System.out.println("0. Exit.");
						edit = Validator.inputInt("Enter your choice: ", 0, 1);
						if (edit == 1) {
							String ID = Validator.inputString("Enter ID lector you want edit: ").toUpperCase();
							if (ListLector.checkID(ID)) {

								String phoneNew = Validator.inputPhoneNum("Enter new phone number: ");
								if (listLector.edit(ID, phoneNew))
									System.out.println("Done!!!");
								System.out.println();
							} else {
								System.err.println("Lector with ID: " + ID + " isn't exist!!!");
								System.out.println();
							}
						}
					} while (edit != 0);
				System.out.println();
				break;
			}
			case 4: {
				listLector.removeAll();
				System.out.println();
				break;
			}
			case 5: {
				String id = Validator.inputString("Enter your ID you want remove: ").toUpperCase();
				listLector.removeLector(p -> p.getID().equalsIgnoreCase(id));
				break;
			}
			case 6: {
				String email = Validator.inputEmail("Enter your email you want remove:");
				listLector.removeLector(p -> p.getEmail().equals(email));
				break;
			}
			case 7: {
				String id = Validator.inputString("Enter your ID you want check: ");
				listLector.searchLector(p -> p.getID().equalsIgnoreCase(id));
				System.out.println();
				break;
			}
			case 8: {
				String name = Validator.inputString("Enter name you want search: ");
				listLector.searchLector(p -> p.getName().contains(name));
				System.out.println();
				break;
			}
			case 9: {
				String email = Validator.inputEmail("Enter email you want search: ");
				listLector.searchLector(p -> p.getEmail().equals(email));
				System.out.println();
				break;
			}
			case 10: {
				String subject = Validator.inputString("Enter subject you want search: ").toUpperCase();
				listLector.searchLector(p -> p.getSubject().equalsIgnoreCase(subject));
				System.out.println();
				break;
			}
			case 11: {
				listLector.sortByName();
				System.out.println();
				break;
			}
			case 12: {
				try {
					listLector.readFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
			case 13: {
				try {
					listLector.writeFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
			}
		} while (choice != 0);
	}
}
