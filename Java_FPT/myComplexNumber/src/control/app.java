package control;

import model.complexNumber;

public class app {
	public static void main(String[] args) {
		complexNumber c1 = new complexNumber(2.3,6.2);
		complexNumber c2 = new complexNumber(6.3,4.1);
		
		System.out.println(c1.outPut());
		System.out.println(c2.outPut());
		
		complexNumber c3 = c1.sum(c2);
		System.out.println("Sum: "+c3.outPut());
		
		complexNumber c4 = c1.sub(c2);
		System.out.println("Sub: "+c4.outPut());

		complexNumber c5 = c1.multi(c2);
		System.out.println("Multi: "+c5.outPut());
		
		complexNumber c6 = c1.div(c2);
		System.out.println("Divide: "+c6.outPut());
	}
}
