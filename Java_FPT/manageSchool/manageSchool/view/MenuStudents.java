package view;

import module.ListStudent;
import module.Student;
import module.Validator;

public class MenuStudents extends Menu {

	ListStudent listStudent;
	Validator validator = new Validator();

	public MenuStudents() {
	}

	public MenuStudents(String notification, String[] options, ListStudent listStudent) {
		super(notification, options);
		this.listStudent = listStudent;
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
				listStudent.printListStudents();
				break;
			}
			case 2: {
				Student student = new Student();
				student.inputInfo();
				listStudent.add(student);
				break;
			}
			case 3: {
				System.out.println("List student is empty: " + listStudent.isEmpty());
				System.out.println();
				break;
			}
			case 4: {
				System.out.println("Number student in list: " + listStudent.getSize());
				System.out.println();
				break;
			}
			case 5: {
				listStudent.removeAll();
				System.out.println();
				break;
			}
			case 6: {
				Student studentID = new Student(validator.inputID("Enter your ID you want remove: "));
				listStudent.removeByID(studentID);
				break;
			}
			case 7: {
				Student studentID = new Student(validator.inputID("Enter your ID you want check: "));
				if (!listStudent.findByID(studentID))
					System.out.println("Student with ID: " + studentID.getID() + " isn't exist!!!");
				System.out.println();
				break;
			}
			case 8: {
				String name = validator.inputString("Enter name you want search: ");
				if (!listStudent.findByName(name))
					System.out.println("Student with name " + name + " isn't exist!!!");
				System.out.println();
				break;
			}
			case 9: {
				listStudent.printScholarShip();
				System.out.println();
				break;
			}
			case 10: {
				listStudent.sortByName();
				System.out.println();
				break;
			}
			case 11: {
				listStudent.sortByAverage();
				System.out.println();
				break;
			}
			}
		} while (choice != 0);
	}
	
}
