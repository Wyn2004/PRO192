package module;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Receiver {

	private String note;
	private int money;
	private Date create;
	private Validator validator= new Validator();

	public Receiver() {
	}
	
	public void inputReceiver() {
		
		System.out.println("============= ENTER DESPOSIT INFORMATION =============");
		this.money = validator.inputMoney("Enter the amount you want to deposit: ", 1, Integer.MAX_VALUE);
		this.note = validator.inputString("Takes note: ");
		this.create = new Date();
		System.out.println("Received succesfull!!! ");
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
	
	public String getCreateString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss dd/MM/yyy");
		return dateFormat.format(create).toString();
	}

	@Override
	public String toString() {
		return "Receiver: [note=" + note + ", money=" + money + "$, create=" + getCreateString() + "]";
	}

	public void displayReceiver() {
		System.out.println(toString());
	}
}
