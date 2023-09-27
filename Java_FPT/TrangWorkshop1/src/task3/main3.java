package task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<String> list = new ArrayList<String>();

		System.out.print("Enter number of list:");
		int size = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < size; i++) {
			System.out.print("Enter name of student " + i + " :");
			String name = sc.nextLine();
			list.add(name);
		}

		for (String name : list) {
			char[] c = name.toCharArray();
			for (int i = 0; i < c.length; i++) {
				if ((i == 0) || (Character.isLetter(c[i]) && (c[i - 1] == ' ')))
					c[i]=Character.toUpperCase(c[i]);
				System.out.print(c[i]);
			}
			System.out.println();
		}

		sc.close();
	}
}
