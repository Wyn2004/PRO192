package View;

import Module.Brand;
import Module.BrandList;
import Module.Validator;

public class MenuBrand extends Menu {

	private BrandList brandList;
	private String[] options;
	private Validator validator = new Validator();

	public MenuBrand(String menuName, String[] options, BrandList brandList) {
		this.options = options;
		this.brandList = brandList;
	}

	public Brand getChoice() {
		brandList.displayListBrand();
		int choice = validator.inputInt("Enter your choice: ", 1, options.length);
		return brandList.getBrandList().get(choice-1);
	}

	@Override
	public void execute() {
	}

}
