package Controller;

import java.io.IOException;

import View.EnrollView;
import View.Menu;
import View.StudentView;
import View.SubjectView;

public class UniversityController extends Menu {

	private StudentController studentController = new StudentController();
	private SubjectController subjectController = new SubjectController();
	private EnrollController enrollController = new EnrollController();

	public UniversityController() {
	}

	public UniversityController(String nameMenu, String[] options) {
		super(nameMenu, options);
	}

	@Override
	public void execute() {
		int choice;

		do {
			choice = displayMenu();
			System.out.println();
			switch (choice) {
			case 1: {

				String[] options = { "Add student", "Display student list", "Return" };
				Menu menuStudent = new Menu("Manage Student", options) {

					@Override
					public void execute() {
						int choice;
						do {
							choice = displayMenu();
							System.out.println();
							switch (choice) {
							case 1: {
								studentController.add();
								System.out.println();
								break;
							}
							case 2: {
								if (!studentController.getStudentList().isEmpty()) {
									StudentView.displayStudentList(studentController.getStudentList());
								} else
									System.err.println("List student is empty!!");
								System.out.println();
								break;

							}

							case 3: {
								try {
									studentController.writeFile();
								} catch (IOException e) {
									e.printStackTrace();
								}
								System.out.println("Data has been saved at Student_Output.txt !!!");
								System.out.println("Good bye!!!!");
								break;
							}
							}
						} while (choice != 3);
					}
				};
				menuStudent.execute();
				System.out.println();
				break;
			}
			case 2: {

				String[] options = { "Add subject", "Display subject list", "Return" };
				Menu menuSubject = new Menu("Manage Subject", options) {

					@Override
					public void execute() {
						int choice;
						do {
							choice = displayMenu();
							System.out.println();
							switch (choice) {
							case 1: {
								subjectController.add();
								System.out.println();
								break;
							}
							case 2: {
								if (!subjectController.getSubjectList().isEmpty()) {
									SubjectView.displaySubjectList(subjectController.getSubjectList());
								} else
									System.err.println("List subject is empty!!");
								System.out.println();
								break;

							}

							case 3: {
								try {
									subjectController.writeFile();
								} catch (IOException e) {
									e.printStackTrace();
								}
								System.out.println("Data has been saved at Subject_Output.txt !!!");
								System.out.println("Good bye!!!!");
								break;
							}
							}
						} while (choice != 3);
					}
				};
				menuSubject.execute();
				System.out.println();
				break;
			}
			case 3: {
				String[] options = { "Add enroll", "Display enroll list", "Return" };
				Menu menuEnroll = new Menu("Manage Enroll", options) {

					@Override
					public void execute() {
						int choice;
						do {
							choice = displayMenu();
							System.out.println();
							switch (choice) {
							case 1: {
								enrollController.add();
								System.out.println();
								break;
							}
							case 2: {
								if (!enrollController.getEnrollList().isEmpty()) {
									EnrollView.displayEnrollList(enrollController.getEnrollList());
								} else
									System.err.println("List enroll is empty!!");
								System.out.println();
								break;

							}

							case 3: {
								try {
									enrollController.writeFile();
								} catch (IOException e) {
									e.printStackTrace();
								}
								System.out.println("Data has been saved at Enroll_Output.txt !!!");
								System.out.println("Good bye!!!!");
								break;
							}
							}
						} while (choice != 3);
					}
				};
				menuEnroll.execute();
				System.out.println();
				break;
			}

			case 4: {
				System.out.println("Good bye!!!!");
				break;
			}
			}
		} while (choice != 4);
	}

	public static void main(String[] args) {

		String[] options = { "Student", "Subject", "Enroll", "Exit" };
		Menu mainMenu = new UniversityController("Magenement University", options);
		mainMenu.execute();

	}
}