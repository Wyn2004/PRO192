package view;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import module.IFileInfor;
import module.ListLector;
import module.ListStudent;
import module.School;

public class MainMenu extends Menu implements IFileInfor {

	private static School school = new School();
	//
	private ListStudent listStudent = new ListStudent();
	///
	private ListLector listLector = new ListLector();

	public MainMenu() {
	}

	public MainMenu(String nameMenu, String[] options) {
		super(nameMenu, options);
	}

	@Override
	public void execute() {
		int choice;

		do {
			choice = displayMenu();
			System.out.println();
			switch (choice) {
			case 0: {
				System.out.println("Good bye!!!!");
				break;
			}
			case 1: {
				String[] studentOptions = { "Print list students.", "Add a student.", "Check list student is empty.",
						"Get size of list Student.", "Edit.", "Remove all students in list.", "Remove student by ID.",
						"Remove by email.", "Find Student by ID.", "Find student by name.", "Find by email.",
						"Find by major.", "Print all students have scholarship.", "Sort list student by name.",
						"Sort list student by average.", "Back." };
				Menu menuStudents = new MenuStudents("Manage Student", studentOptions, listStudent);
				menuStudents.execute();
				school = new School(listStudent, listLector);
				System.out.println();
				break;
			}
			case 2: {
				String[] lectorOptions = { "Print list lector.", "Add a lector.", "Check list lector is empty.",
						"Get size of list lector.", "Edit.", "Remove all lector in list.", "Remove lector by ID.",
						"Remove by email.", "Find lector by ID.", "Find lector by name.", "Find by email",
						"Find by major.", "Sort list lector by name.", "Back." };
				if (listLector == null)
					listLector = new ListLector();
				Menu menuLectors = new MenuLector("Manage Lector", lectorOptions, listLector);
				menuLectors.execute();
				school = new School(listStudent, listLector);
				System.out.println();
				break;

			}
			case 3: {
				try {
					writeFile();
					System.out.println("Export data successfully, data save with this format!!!");
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
			case 4: {
				try {
					readFile();
					System.out.println("Read data successfully !!!");
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
			}
		} while (choice != 0);
	}

	@Override
	public void writeFile() throws IOException {

		FileOutputStream fos = new FileOutputStream("School.txt");

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();

		String data = gson.toJson(school);
		fos.write(data.getBytes());
		System.out.println(data);

	}

	@Override
	public void readFile() throws IOException {

		Gson gson = new Gson();
		FileReader data = new FileReader("SchoolData.txt");

		Type type = new TypeToken<School>() {
		}.getType();

		this.school = gson.fromJson(data, type);
		this.listStudent = this.school.getStudent_list();
		this.listLector = this.school.getLector_list();
		school.display();
		System.out.println();
	}

}
