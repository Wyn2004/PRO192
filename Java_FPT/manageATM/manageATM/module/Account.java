package module;

import java.util.ArrayList;

public class Account {

	Validator validator = new Validator();
	private String fullName;
	private String numRoll;
	private String phoneNumber;
	private String adress;
	private int money;
	private ArrayList<Receiver> receiverList = new ArrayList<>();
	private ArrayList<Transfer> transferList = new ArrayList<>();

	public Account() {
	}

	public Account(String fullName, String numRoll, String phoneNumber, String adress, int money) {

		this.fullName = fullName;
		this.numRoll = numRoll;
		this.phoneNumber = phoneNumber;
		this.adress = adress;
		this.money = money;
	}

	public void inputAccount() {

		System.out.println("============= WELCOME TO OUR BANK =============");
		this.fullName = validator.inputString("Enter full name: ");
		this.numRoll = validator.inputNumRoll("Enter roll number you want (more than 6 number): ");
		this.phoneNumber = validator.inputPhoneNumber("Enter your phone number: ");
		this.adress = validator.inputString("Enter your adress: ");
		this.money = validator.inputMoney("Enter your money: ", 1, Integer.MAX_VALUE);
		System.out.println("Thank you for choosing our service !!! ");
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = validator.inputString("Enter full name: ");
	}

	public String getNumRoll() {
		return numRoll;
	}

	public void setNumRoll(String numRoll) {
		this.phoneNumber = validator.inputNumRoll("Enter numroll you want (more than 6 number): ");
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = validator.inputPhoneNumber("Enter your phone number: ");
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = validator.inputString("Enter your adress: ");
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = validator.inputMoney("Enter your money: ", 0, Integer.MAX_VALUE);
	}

	public void addReceiver() {
		if (this.money > 0) {
			Receiver receiver = new Receiver();
			receiver.inputReceiver();
			receiverList.add(receiver);
			this.money += receiver.getMoney();
		} else
			System.err.println("Your account does not have enough balance to make this transaction!!!");
	}

	public void displayAllReceived() {

		if (this.receiverList.size() > 0)
			for (Receiver receiver : receiverList)
				receiver.displayReceiver();
		else
			System.err.println("There have been no previous deposits!!!");
	}

	public void addTransfer() {

		Transfer transfer = new Transfer(this.money);
		transfer.inputTransfer();
		transferList.add(transfer);
		this.money -= transfer.getMoney();
	}

	public void displayAllTransferred() {

		if (this.transferList.size() > 0)
			for (Transfer transfer : transferList) 
				transfer.displayTransfer();
		else
			System.err.println("There have been no previous transferred !!!");
	}

	@Override
	public String toString() {

		return "Account: [fullName=" + fullName + ", numRoll=" + numRoll + ", phoneNumber=" + phoneNumber + ", adress="
				+ adress + ", money=" + money + "$]";
	}

	public void displayAccount() {

		System.out.println(toString());
	}
}
