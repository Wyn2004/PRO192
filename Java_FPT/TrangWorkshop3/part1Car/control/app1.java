package control;

import module.myCar;

public class app1 {
	public static void main(String[] args) {
		
		myCar c = new myCar();
		
		c.pressStarButton();
		c.pressAcceleratorButton();
		c.output();
		
		myCar c2 = new myCar("red", 100, true, true);
		
		c2.pressAcceleratorButton();
		c2.setColour("Black");
		System.out.println("Colour of c2:" + c2.getColour());
		c2.output();
	}
}
