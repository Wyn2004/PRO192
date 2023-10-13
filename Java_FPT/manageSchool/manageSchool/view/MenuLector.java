package view;

import module.Lector;
import module.ListLector;
import module.Validator;

public class MenuLector extends Menu{
	
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
				listLector.removeAll();
				System.out.println();
				break;
			}
			case 6: {
				Lector lectorID = new Lector(validator.inputID("Enter your ID you want remove: "));
				listLector.removeByID(lectorID);
				break;
			}
			case 7: {
				Lector lectorID = new Lector(validator.inputID("Enter your ID you want check: "));
				if (!listLector.findByID(lectorID))
					System.out.println("Lector with ID: " + lectorID.getID() + " isn't exist!!!");
				System.out.println();
				break;
			}
			case 8: {
				String name = validator.inputString("Enter name you want search: ");
				if (!listLector.findByName(name))
					System.out.println("Lector with name " + name + " isn't exist!!!");
				System.out.println();
				break;
			}
			case 9: {
				listLector.sortByName();
				System.out.println();
				break;
			}
			}
		} while (choice!=0);
	}
}
