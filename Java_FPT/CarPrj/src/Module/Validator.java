package Module;

import java.util.List;
import java.util.Scanner;

public class Validator {

	private final static Scanner sc = new Scanner(System.in);

	public Validator() {
	}

	public String inputString(String notification) {
		System.out.print(notification);
		while (true) {
			String result = sc.nextLine().trim().toUpperCase();
			if (result == null || result.length() == 0) {
				System.err.print("Error: Invalid input, please try again: ");
				continue;
			}
			return result;
		}
	}

	public int inputInt(String notification, int min, int max) {
		System.out.print(notification);
		int number = 0;
		while (true) {
			try {
				number = Integer.parseInt(sc.nextLine().trim());
			} catch (NumberFormatException e) {
				System.err.print("Error: Invalid input, please try again: ");
				continue;
			}
			if (number < min || number > max) {
				System.err.print("Error: Invalid input, please try again: ");
				continue;
			}
			return number;
		}
	}

	public double inputDouble(String notification, double min, double max) {
		System.out.print(notification);
		double number = 0;
		while (true) {
			try {
				number = Double.parseDouble(sc.nextLine().trim());
			} catch (NumberFormatException e) {
				System.err.print("Error: Invalid input, please try again: ");
				continue;
			}
			if (number < min || number > max) {
				System.err.print("Error: Invalid input, please try again: ");
				continue;
			}
			return number;
		}
	}

	public String inputIDBrand(String notification, List<Brand> list) {
		System.out.print(notification);
		while (true) {
			Boolean check = true;
			String result = sc.nextLine().trim().toUpperCase();
			for (Brand brand : list)
				if (brand.getBrandId().equals(result)) {
					check = false;
					break;
				}
			if (result == null || result.length() == 0 || !check) {
				System.err.print("Error: Invalid input, please try again: ");
				continue;
			}
			return result;
		}
	}
	
	public String inputNameBrand(String notification, List<Brand> list) {
		System.out.print(notification);
		while (true) {
			Boolean check = true;
			String result = sc.nextLine().trim().toUpperCase();
			for (Brand brand : list)
				if (brand.getBrandName().equals(result)) {
					check = false;
					break;
				}
			if (result == null || result.length() == 0 || !check) {
				System.err.print("Error: Invalid input, please try again: ");
				continue;
			}
			return result;
		}
	}
	
	public String inputSoundBrand(String notification, List<Brand> list) {
		System.out.print(notification);
		while (true) {
			Boolean check = true;
			String result = sc.nextLine().trim().toUpperCase();
			for (Brand brand : list)
				if (brand.getSoundBrand().equals(result)) {
					check = false;
					break;
				}
			if (result == null || result.length() == 0 || !check) {
				System.err.print("Error: Invalid input, please try again: ");
				continue;
			}
			return result;
		}
	}
	
	public String inputIDCar(String notification, List<Car> list) {
		System.out.print(notification);
		while (true) {
			Boolean check = true;
			String result = sc.nextLine().trim().toUpperCase();
			for (Car car : list)
				if (car.getCarID().equals(result)) {
					check = false;
					break;
				}
			if (result == null || result.length() == 0 || !check) {
				System.err.print("Error: Invalid input, please try again: ");
				continue;
			}
			return result;
		}
	}
	
	public String inputFrameID(String notification, List<Car> list) {
		System.out.print(notification);
		while (true) {
			Boolean check = true;
			String result = sc.nextLine().trim().toUpperCase();
			for (Car car : list)
				if (car.getFrameID().equals(result)) {
					check = false;
					break;
				}
			if (result == null || result.length() == 0 || 
				result.length()<6 || !result.startsWith("F") || !check) {
				System.err.print("Error: Invalid input, please try again: ");
				continue;
			}
			return result;
		}
	}
	
	public String inputEngineID(String notification, List<Car> list) {
		System.out.print(notification);
		while (true) {
			Boolean check = true;
			String result = sc.nextLine().trim().toUpperCase();
			for (Car car : list)
				if (car.getEngineID().equals(result)) {
					check = false;
					break;
				}
			if (result == null || result.length() == 0 || 
				result.length()<6 || !result.startsWith("E") || !check) {
				System.err.print("Error: Invalid input, please try again: ");
				continue;
			}
			return result;
		}
	}
}
