package Module;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import View.MenuBrand;

public class CarList {

	private List<Car> carList = new ArrayList<>();
	private BrandList brandList;
	private Validator validator = new Validator();

	public CarList(BrandList brandList) {
		this.brandList = brandList;
	}

	public List<Car> getCarList() {
		return carList;
	}

	public void setCarList(List<Car> carList) {
		this.carList = carList;
	}

	public BrandList getBrandList() {
		return brandList;
	}

	public void setBrandList(BrandList brandList) {
		this.brandList = brandList;
	}

	public void addCar() {

		Car car = new Car();
		car.setCarID(validator.inputIDCar("Enter car ID: ", carList));
		MenuBrand menuBrand = new MenuBrand("Menu Brand Car.", brandList.getOption(), brandList);
		car.setBrand(menuBrand.getChoice());
		car.setColor(validator.inputString("Enter color: "));
		car.setFrameID(validator.inputFrameID("Enter frame ID: ", carList));
		car.setEngineID(validator.inputEngineID("Enter engineer ID: ", carList));
		carList.add(car);
	}

	public int searchID(String oID) {
		for (int i = 0; i < carList.size(); i++)
			if (carList.get(i).getCarID().equals(oID))
				return i;
		return -1;
	}

	public void removeByID(String ID) {
		if (!carList.isEmpty()) {
			for (Car car : carList)
				if (car.getCarID().equals(ID)) {
					carList.remove(car);
					return;
				}
			System.err.println("Car with ID is not exist!!!");
		} else
			System.err.println("List car is empty!!!");
	}

	public void updateCar() {

		String ID = validator.inputString("Enter ID of car want update: ");
		int index = searchID(ID);
		if (index < 0)
			System.err.println("ID car is not exist!!!");
		else {
			carList.remove(index);
			addCar();
		}
	}

	public void printBasedBrandName(String brandName) {

		int count = 0;
		for (Car car : carList)
			if (car.getBrand().getBrandName().contains(brandName)) {
				count++;
				System.out.println(car.toScreenString() + "\n");
			}
		if (count == 0)
			System.err.println("No car is detected!!!");
	}

	public void displayListCar() {
		if (!carList.isEmpty()) {
			Collections.sort(carList);
			for (Car car : carList)
			System.out.println(car.toScreenString());
		} else
			System.err.println("List car is empty!!!");
	}
}
