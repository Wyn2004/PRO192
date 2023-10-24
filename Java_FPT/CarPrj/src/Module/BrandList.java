package Module;

import java.util.ArrayList;
import java.util.List;

public class BrandList {

	private List<Brand> brandList = new ArrayList<>();
	private Validator validator = new Validator();

	public BrandList() {

	}

	public List<Brand> getBrandList() {
		return brandList;
	}

	public void setBrandList(List<Brand> brandList) {
		this.brandList = brandList;
	}

	public void addBrand() {

		Brand brand = new Brand();
		brand.setBrandId(validator.inputIDBrand("Enter brand ID: ", brandList));
		brand.setBrandName(validator.inputNameBrand("Enter brand name: ", brandList));
		brand.setSoundBrand(validator.inputSoundBrand("Enter sound brand: ", brandList));
		brand.setPrice(validator.inputDouble("Enter price brand: ", 0, Double.MAX_VALUE));
		brandList.add(brand);
	}

	public void displayListBrand() {

		if (!brandList.isEmpty()) {
			System.out.println("List brand: ");
			for (int i = 0; i < brandList.size(); i++) {
				System.out.println(i + 1 + ". " + brandList.get(i));
			}

		} else
			System.err.println("List brand is empty!!!");
	}

	public int searchID(String oID) {

		for (int i = 0; i < brandList.size(); i++)
			if (brandList.get(i).getBrandId().equals(oID)) {
				return i;
			}
		return -1;
	}

	public void updateBrand() {

		String ID = validator.inputString("Enter ID of brand want update: ");
		int index = searchID(ID);
		if (index < 0)
			System.err.println("ID brand is not exist!!!");
		else {
			brandList.remove(index);
			addBrand();
		}
	}

	public String[] getOption() {

		String[] options = new String[brandList.size()];
		for (int i = 0; i < brandList.size(); i++)
			options[i] = brandList.get(i).getBrandName();
		return options;
	}
}
