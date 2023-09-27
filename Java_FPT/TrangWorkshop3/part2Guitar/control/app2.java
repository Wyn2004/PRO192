package control;

import module.myGuitar;

public class app2 {
	public static void main(String[] args) {
		
		myGuitar obj1 = new myGuitar();
		myGuitar obj2 = new myGuitar("G123", 2000, "Sony", "Model123", "hardWood", "softWood");
		
		System.out.println("State of obj1:");
		obj1.createSound();
		
		System.out.println("State of obj2:");
		obj2.createSound();
		
		System.out.println("set price = 3000 of obj1");
		obj1.setPrice(3000);
		
		System.out.println("get price of obj1:" + obj1.getPrice());
		
	}
}
