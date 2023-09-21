package control;

import model.myPoint;

public class app {
	public static void main(String[] args) {

		myPoint p1 = new myPoint(1, 2);
		myPoint p2 = new myPoint(4, 4.2);
		myPoint p3 = new myPoint(3.4, 6.5);

		System.out.println(p1.outPut());
		System.out.println(p2.outPut());
		System.out.println(p3.outPut());

		System.out.println("Distance form p1->p2: " + p1.distance(p2));
		System.out.println("Area of triangle: " + p1.findTriAngle(p2, p3));
	}
}
