package control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<String> listStd = new ArrayList<String>();
		
		System.out.print("Enter full name: ");
		String nameStd = scanner.nextLine();
		
		listStd.add("Nguyen Hieu");
		listStd.add("Le Khoi");
		listStd.add("To Nhan");
		listStd.add("Trinh Thang");
		listStd.add("Ha");
		
		for (String name : listStd) {
			if (nameStd.equals(name)) {
				System.out.println("Yes");
				scanner.close();
				return;
			}
		}
		System.out.println("No");
		scanner.close();
	}
}
