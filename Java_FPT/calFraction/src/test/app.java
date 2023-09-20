package test;

import myFraction.myFraction;

public class app {
	public static void main(String[] args) {

		myFraction f1 = new myFraction(0, 5);
		myFraction f2 = new myFraction(10, 10);

		System.out.println("Fraction 1: " + f1.toStringFraction());
		f2.compactFraction();
		System.out.println("Fraction 2: " + f2.toStringFraction());
		
		myFraction sumFraction = f1.sumTwoFraction(f2);
		System.out.println("Sum: " + sumFraction.toStringFraction());
		
		myFraction minusFraction = f1.minusTwoFraction(f2);
		System.out.println("Minus: " + minusFraction.toStringFraction());
		
		myFraction multiFraction = f1.multiTwoFraction(f2);
		System.out.println("Multiply: "+multiFraction.toStringFraction());
		
		myFraction divFraction = f1.divTwoFraction(f2);
		System.out.println("Divide: "+divFraction.toStringFraction());
	}
}
