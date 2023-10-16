package view;

import module.Lector;
import module.ListLector;
import module.Student;
import module.Validator;

public class MenuLector extends Menu {

	ListLector listLector;
	Validator validator = new Validator();

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
				System.out.println("Backed main menu !!!");
				System.out.println();
				break;
			}
			case 1: {
				listLector.printListLector();
				break;
			}
			case 2: {
				Lector lector = new Lector();
				lector.inputInfo();
				listLector.add(lector);
				break;
			}
			case 3: {
				System.out.println("List lector is empty: " + listLector.isEmpty());
				System.out.println();
				break;
			}
			case 4: {
				System.out.println("Number lector in list: " + listLector.getSize());
				System.out.println();
				break;
			}
			case 5: {
				int edit = 0;
				if (listLector.isEmpty())
					System.err.println("List is empty!!!");
				else
					do {
						listLector.printListLector();
						System.err.println("You just only edit phone number!!!");
						System.out.println("1. Edit.");
						System.out.println("0. Exit.");
						edit = validator.inputInt("Enter your choice: ", 0, 1);
						if (edit == 1) {
							String ID = validator.inputID("Enter ID lector you want edit: ");
							Lector lectorEdit = new Lector(ID);
							if (listLector.findByID(lectorEdit)) {

								String phoneNew = validator.inputPhoneNum("Enter new phone number: ");
								if (listLector.edit(ID, phoneNew))
									System.out.println("Done!!!");
								System.out.println();
							} else {
								System.err.println("Lector with ID: " + lectorEdit.getID() + " isn't exist!!!");
								System.out.println();
							}
						}
					} while (edit != 0);
				System.out.println();
				break;
			}
			case 6: {
				listLector.removeAll();
				System.out.println();
				break;
			}
			case 7: {
				Lector lectorID = new Lector(validator.inputID("Enter your ID you want remove: "));
				listLector.removeByID(lectorID);
				break;
			}
			case 8: {
				String email = this.validator.inputEmail("Enter your email you want remove:");
				listLector.removeByEmail(email);
				break;
			}
			case 9: {
				Lector lectorID = new Lector(validator.inputID("Enter your ID you want check: "));
				if (!listLector.findByID(lectorID))
					System.err.println("Lector with ID: " + lectorID.getID() + " isn't exist!!!");
				System.out.println();
				break;
			}
			case 10: {
				String name = validator.inputString("Enter name you want search: ");
				if (!listLector.findByName(name))
					System.err.println("Lector with name " + name + " isn't exist!!!");
				System.out.println();
				break;
			}
			case 11: {
				String email = validator.inputEmail("Enter email you want search: ");
				if (!listLector.findByEmail(email))
					System.err.println("Lector with email " + email + " isn't exist!!!");
				System.out.println();
				break;
			}
			case 12: {
				String subject = validator.inputString("Enter subject you want search: ");
				if (!listLector.findBySubject(subject.toUpperCase()))
					System.err.println("Lector with subject " + subject + " isn't exist!!!");
				System.out.println();
				break;
			}
			case 13: {
				listLector.sortByName();
				System.out.println();
				break;
			}
			}
		} while (choice != 0);
	}
}
