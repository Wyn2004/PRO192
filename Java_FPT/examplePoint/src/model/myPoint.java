package model;

public class myPoint {

	private double x;
	private double y;

	// Create default constructor
	public myPoint() {
		this.x = 0;
		this.y = 0;
	}

	// Create constructor
	public myPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return this.x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return this.y;
	}

	public void setY(double y) {
		this.y = y;
	}

	// Find distance
	public double distance(myPoint orPoint) {
		double d = Math.sqrt(Math.pow(this.getX() - orPoint.getX(), 2) + Math.pow(this.getY() - orPoint.getY(), 2));
		return (double) (Math.round(d * 100)) / 100;
	}

	// Point to string
	public String outPut() {
		return "(" + this.x + ";" + this.y + ")";
	}

	// Find area triangle
	public double findTriAngle(myPoint p2, myPoint p3) {
		double d1 = this.distance(p2);
		double d2 = p2.distance(p3);
		double d3 = p3.distance(this);
		double p = (d1 + d2 + d3) / 2;
		double s = Math.sqrt(p * (p - d1) * (p - d2) * (p - d3));
		return (double) (Math.round(s * 100)) / 100;
	}
}
