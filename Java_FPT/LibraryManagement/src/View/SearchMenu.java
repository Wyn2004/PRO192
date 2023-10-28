package View;

import Module.Library;
import Module.Validator;

public class SearchMenu extends Menu {

	private Library library;
	private Validator validator = new Validator();

	public SearchMenu() {

	}

	public SearchMenu(String menuName, String[] options, Library library) {
		super(menuName, options);
		this.library = library;
	}

	@Override
	public void execute() {

	}

}
