package module;

import java.util.Scanner;

public class Validator {
	
	private final Scanner scanner= new Scanner(System.in);

	public Validator() {
	}
	
	public String inputUserName(String mess) {
		
		System.out.print(mess);
		while (true) {
			String data = scanner.nextLine();
			if (data == null || data.length()==0)	{
				System.err.print("Error: Invalid USER, Please enter user again: ");
				continue;
			}
				return data;
		}
	}
	
	public String inputPassWord(String mess) {
		
		System.out.print(mess);
		while (true) {
			String data = scanner.nextLine();
			if (data == null || data.length()<8 || "0123456789".contains(data))	{
				System.err.print("Error: Invalid PASSWORD, Please enter user again (contain charecter number): ");
				continue;
			}
				return data;
		}
	}
	
	public int inputInt(String mess, int min, int max) {
		
		System.out.print(mess);
		int num = 0;
		while(true)	{
			try {
				num = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.err.print("Error: Invalid input, please try again: ");
				continue;
			}
			if (num<min || num>max) {
				System.err.print("Error: Invalid input, please try again: ");
				continue;
			}
			return num;
		}	
	}
	
	public String inputString(String mess) {
		
		System.out.print(mess);
		while (true) {
			String data = scanner.nextLine();
			if (data == null || data.length()==0 || "0123456789".contains(data))	{
				System.err.print("Error: Invalid input, Please try again: ");
				continue;
			}
				return data;
		}
	}
	
	public String inputNumRoll(String mess) {
		
		System.out.print(mess);
		while (true) {
			String data = scanner.nextLine();
			if (data==null || data.length() <=6 || !data.matches("[0-9]+"))	{
				System.err.print("Error: Invalid roll number, please try again: ");
				continue;
			}
			return data;
		}
	}
	
	public String inputPhoneNumber(String mess) {
		
		System.out.print(mess);
		while (true) {
			String data = scanner.nextLine();
			if (data==null || data.length() <10 || !data.matches("[0-9]+"))	{
				System.err.print("Error: Invalid phone number (less than 10 number), please try again: ");
				continue;
			}
			return data;
		}
	}
	
	public int inputMoney(String mess, int min, int max) {
		
		System.out.print(mess);
		int money;
		while(true)	{
			try {
				money = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.err.print("Error: Invalid money, please try again: ");
				continue;
			}
			if (money<min || money>max) {
				System.err.print("Error: Invalid money, please try again: ");
				continue;
			}
			return money;
		}
	}
}
