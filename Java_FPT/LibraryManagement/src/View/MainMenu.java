package View;

import java.io.IOException;

import Module.IFileInfo;

public class MainMenu extends Menu implements IFileInfo{


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
			case 1: {
				String[] Options_1 = { "Options ....", "Back." };
				//// Execute 1
				System.out.println();
				break;
			}
			case 2: {
				String[] Options_1 = { "Options ....", "Back." };
				// Execute 2
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
			case 5: {
				System.out.println("Good bye!!!!");
				break;
			}
			}
		} while (choice != 5);
	}

	@Override
	public void writeFile() throws IOException {
		//////////
	}

	@Override
	public void readFile() throws IOException {
		//////////
	}

}