package module;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transfer {

	private String numRollTransfer;
	private String nameTransfer;
	private String note;
	private int money;
	private Date create;
	private Validator validator= new Validator();
	private int moneyHave;
	
	public Transfer() {

	}
	
	public Transfer(int moneyHave) {
		this.moneyHave = moneyHave;
	}
	
	public void inputTransfer() {
		
		System.out.println("============= ENTER TRANSFER INFORMATION =============");
		this.nameTransfer = validator.inputString("Enter full name people you want transfer: ");
		this.numRollTransfer = validator.inputNumRoll("Enter roll number you want to transfer: ");
		this.money = validator.inputMoney("Enter the amount you want to transfer: ", 1, moneyHave);
		this.note = validator.inputString("Takes note: ");
		this.create = new Date();
		System.out.println("Transfer succesfull !!!");
	}

	public String getNameTransfer() {
		return nameTransfer;
	}

	public void setNameTransfer(String nameTransfer) {
		this.nameTransfer = nameTransfer;
	}

	public String getNumRollTransfer() {
		return numRollTransfer;
	}

	public void setNumRollTransfer(String numRollTransfer) {
		this.numRollTransfer = numRollTransfer;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public Date getCreate() {
		return create;
	}

	public void setCreate(Date create) {
		this.create = create;
	}
	
	public String getCreateString()	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss dd/MM/yyy");
		return dateFormat.format(create).toString();
	}

	@Override
	public String toString() {
		return "Transfer: [numRollTransfer=" + numRollTransfer + ", nameTransfer=" + nameTransfer + ", note=" + note
				+ ", money=" + money + "$, create=" + getCreateString() + "]";
	}
	
	public void displayTransfer() {
		System.out.println(toString());
	}
	
	
}
