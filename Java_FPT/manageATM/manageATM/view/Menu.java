package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import module.Account;
import module.Login;
import module.Receiver;
import module.Validator;

public class Menu {
 
	Validator validator = new Validator();
	Account account = new Account();
	Login login = new Login();

	public Menu() {
	}

	public void displayMenu() {
		System.out.println("----------------------- Menu Option -----------------------");
		System.out.println("---         	1. Creat a new account.                 ---");
		System.out.println("---   	    	2. Show my acccount.          	    	---");
		System.out.println("---   	    	3. Change my password.                  ---");
		System.out.println("---             4. Recharge money.                      ---");
		System.out.println("---             5. Transfer money.                      ---");
		System.out.println("---             6. Show history recharge money.         ---");
		System.out.println("---             7. Show history transfer.               ---");
		System.out.println("---             8. Save to file.                        ---");
		System.out.println("---             9. Read file.                           ---");
		System.out.println("---             0. Exit.                                ---");
		System.out.println("-----------------------------------------------------------");
	}

	public void execute() throws IOException {

		int choice;
		do {
			displayMenu();
			choice = validator.inputInt("Enter your choice: ", 0, 9);
			System.out.println();
			switch (choice) {
			case 1: {
				if (account.getNumRoll() != null) {
					System.err.println("You already have account...");
					System.out.println();
				} else
					account.inputAccount();
				System.out.println();
				break;
			}
			case 2: {
				if (account.getNumRoll() == null) {
					System.err.println("You do not have any account. Please create a count in firt choice !!!");
				} else
					account.displayAccount();
				System.out.println();
				break;
			}
			case 3: {
				String oldPass = validator.inputPassWord("Enter old password: ");
				if (login.checkPassWord(oldPass)) {
					String newPass = validator.inputPassWord("Enter new passord: ");
					String newPassAgain = validator.inputPassWord("Enter new password again: ");
					if (newPass.equals(newPassAgain)) {
						login.changePasword(newPassAgain);
						login = new Login(newPassAgain);
						login.inputInfo();
						System.out.println("Change password succesfull. Please login again!!!");
					} else
						System.err.println("Change password failed, change later !!!");
				} else
					System.err.println("Wrong password, change later !!!");
				break;
			}
			case 4: {
				if (account.getNumRoll() != null) {
					account.addReceiver();
					account.displayAccount();
				} else
					System.err.println("You do not have any account ATM!!!");
				System.out.println();
				break;
			}
			case 5: {
				if (account.getNumRoll() != null) {
					account.addTransfer();
					account.displayAccount();
				} else
					System.err.println("You do not have any account ATM!!!");
				System.out.println();
				break;
			}
			case 6: {
				if (account.getNumRoll() != null)
					account.displayAllReceived();
				else
					System.err.println("You do not have any account ATM!!!");
				System.out.println();
				break;
			}
			case 7: {
				if (account.getNumRoll() != null)
					account.displayAllTransferred();
				else
					System.err.println("You do not have any account ATM!!!");
				System.out.println();
				break;
			}
			case 8: {
				writeFile();
				System.out.println("Successfully!!!");
				break;
			}
			case 9: {
				/////
				break;
			}
			}
		} while (choice != 0);
		System.out.println();
		System.out.println("\t\t\tThank you very much!!!");
		System.exit(0);
	}

//	public void writeFile() throws IOException {
//
//		FileOutputStream fos = new FileOutputStream("AccountWrite.txt");
//
//		// Save header
//		fos.write("========\n".getBytes());
//		String line = Account.getInfor();
//		fos.write(line.getBytes());
//		
//		// Save account
//		line = account.getFileInfor();
//		fos.write(line.getBytes());
//		fos.write("========\n\n".getBytes());
//		
//		//Save list receiver
//		fos.write("========\n".getBytes());
//		fos.write(Receiver.getInfor().getBytes());
//		
//		for (Receiver receiver : account.getReceiverList()) {
//			fos.write(receiver.getFileInfor().getBytes());
//		}
//		fos.write("========\n\n".getBytes());
//		
//		//Save list transfer
//		fos.write("========\n".getBytes());
//		fos.write(Transfer.getInfor().getBytes());
//		
//		for (Transfer transfer : account.getTransferList()) {
//			fos.write(transfer.getFileInfor().getBytes());
//			
//		}
//		fos.write("========\n\n".getBytes());
//
//		fos.close();
//	}

	public void writeFile() {

//		FileOutputStream fos = new FileOutputStream("AccountWrite.txt");

		Gson gson = new Gson();

		List<Receiver> list= this.account.getReceiverList();
				
		System.out.println(list);
		String data = gson.toJson(list);
		System.out.println(data);
//		fos.write(data.getBytes());
//		fos.close();
	}
}
