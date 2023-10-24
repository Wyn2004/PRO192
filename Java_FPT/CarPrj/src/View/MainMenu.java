package View;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import Module.Brand;
import Module.BrandList;
import Module.Car;
import Module.CarList;
import Module.IFileInfo;
import Module.Validator;

public class MainMenu extends Menu implements IFileInfo {

	private BrandList brandList = new BrandList();
	private CarList carList = new CarList(brandList);
	private Validator validator = new Validator();

	public MainMenu() {
	}

	public MainMenu(String nameMenu, String[] options) {
		super(nameMenu, options);
	}

	@Override
	public void execute() {
		int choice;
		try {
			readFileBrand();
			readFileCar();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		do {
			choice = displayMenu();
			System.out.println();
			switch (choice) {
			case 0: {
				System.out.println("Good bye!!!!");
				break;
			}
			case 1: {
				brandList.displayListBrand();
				System.out.println();
				break;
			}
			case 2: {
				brandList.addBrand();
				System.out.println("Done!!!");
				System.out.println();
				break;
			}
			case 3: {
				String ID = validator.inputString("Enter ID of brand want search: ");
				if (brandList.searchID(ID) < 0)
					System.err.println("ID brand is not exist!!!");
				else
					System.out.println(brandList.getBrandList().get(brandList.searchID(ID)));
				System.out.println();
				break;
			}
			case 4: {
				brandList.updateBrand();
				System.out.println();
				break;
			}
			case 5: {
				try {
					writeFileBrand();
				} catch (IOException e) {
					e.printStackTrace();
				}

				break;
			}
			case 6: {
				if (!carList.getCarList().isEmpty())
					carList.displayListCar();
				else
					System.err.println("List car is empty!!!");
				System.out.println();
				break;
			}
			case 7: {
				if (!carList.getCarList().isEmpty()) {
					String brandName = validator.inputString("Enter a part brand name want search: ");
					carList.printBasedBrandName(brandName);
				} else
					System.err.println("List car is empty!!!");
				System.out.println();
				break;
			}
			case 8: {
				if (!brandList.getBrandList().isEmpty()) {
					carList.addCar();
					System.out.println("Done!!!");
				} else
					System.err.println("Brand list is empty!!!");
				System.out.println();
				break;
			}
			case 9: {
				if (!carList.getCarList().isEmpty()) {
					String ID = validator.inputString("Enter ID of car want search: ");
					carList.removeByID(ID);
				} else
					System.err.println("List car is empty!!!");
				System.out.println();
				break;
			}
			case 10: {
				if (!carList.getCarList().isEmpty())
					carList.updateCar();
				else
					System.err.println("List car is empty!!!");
				System.out.println();
				break;
			}
			case 11: {
				try {
					writeFileCar();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
			}
		} while (choice != 0);
	}

	@Override
	public void readFileBrand() throws IOException {
		FileReader fr = new FileReader("BrandsData.txt");
		try (BufferedReader reader = new BufferedReader(fr)) {
			String line;
			while ((line = reader.readLine()) != null) {

				String[] tokens1 = line.split(", ");
				String brandID = tokens1[0];
				String brandName = tokens1[1];

				String[] tokens2 = tokens1[2].split(": ");
				String soundBrand = tokens2[0];
				double price = Double.parseDouble(tokens2[1]);
				Brand brand = new Brand(brandID, brandName, soundBrand, price);
				this.brandList.getBrandList().add(brand);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void writeFileBrand() throws IOException {
		try {
			FileOutputStream fos = new FileOutputStream("Brands.txt");
			for (Brand brand : brandList.getBrandList())
				fos.write((brand.toString() + "\n").getBytes());
			System.out.println("Export data brands done!!!");
			System.out.println();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void readFileCar() throws IOException {

		FileReader fr = new FileReader("CarsData.txt");
		try (BufferedReader reader = new BufferedReader(fr)) {
			String line;
			while ((line = reader.readLine()) != null) {

				String[] tokens = line.split(", ");
				String carID = tokens[0];
				int indexBrand = brandList.searchID(tokens[1]);
				Brand brand = brandList.getBrandList().get(indexBrand);
				String color = tokens[2];
				String frameID = tokens[3];
				String engineID = tokens[4];

				Car car = new Car(carID, brand, color, frameID, engineID);
				this.carList.getCarList().add(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void writeFileCar() throws IOException {
		FileOutputStream fos = new FileOutputStream("Cars.txt");
		for (Car car : carList.getCarList())
			fos.write((car.toString()+"\n").getBytes());
		System.out.println("Export data cars done!!!");
		fos.close();
	}

}