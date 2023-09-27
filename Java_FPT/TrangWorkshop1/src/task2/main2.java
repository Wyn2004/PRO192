package task2;

import java.util.Scanner;

public class main2 {
	
	private static void extracted() throws Exception {
		throw new Exception("Invalid expression. Please try again...");
	}
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the expression:");
		int a = scanner.nextInt();
		String c = scanner.next();
		int b = scanner.nextInt();

		switch (c) {
		case "+": {
			System.out.println("Result:" + (a + b));
			break;
		}
		case "-": {
			System.out.println("Result:" + (a - b));
			break;
		}
		case "*": {
			System.out.println("Result:" + (a * b));

			break;
		}
		case "/": {
			try {
				if (b != 0)
					System.out.println("Result:" + (float) a / b);
				else {
					extracted();
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				main(args);
			}
		}
		}
		
		scanner.close();
	}

}
