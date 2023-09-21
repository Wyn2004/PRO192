package model;

public class complexNumber {
	private double real;
	private double image;

	// Create default constructor
	public complexNumber() {
		this.real = 0;
		this.image = 0;
	}

	// Create constructor
	public complexNumber(double real, double image) {
		this.real = real;
		this.image = image;
	}

	// Getter and setter
	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImage() {
		return image;
	}

	public void setImage(double image) {
		this.image = image;
	}

	// Print complex number
	public String outPut() {
		return this.real + " + " + this.image + "i";
	}

	// Sum two complex number
	public complexNumber sum(complexNumber c2) {
		complexNumber sumNumber = new complexNumber();
		sumNumber.real = (double) Math.round((this.real + c2.real) * 100) / 100;
		sumNumber.image = (double) Math.round((this.image + c2.image) * 100) / 100;

		return sumNumber;
	}

	// Sub two complex number
	public complexNumber sub(complexNumber c2) {
		complexNumber subNumber = new complexNumber();
		subNumber.real = (double) Math.round((this.real - c2.real) * 100) / 100;
		subNumber.image = (double) Math.round((this.image - c2.image) * 100) / 100;
		return subNumber;
	}

	// Multiply two complex number
	public complexNumber multi(complexNumber c2) {
		complexNumber multiNumber = new complexNumber();
		multiNumber.real = (double) Math.round((this.real * c2.real - this.image * c2.image) * 100) / 100;
		multiNumber.image = (double) Math.round((this.real * c2.image + this.image * c2.real) * 100) / 100;
		return multiNumber;
	}

	// Divide two complex number
	public complexNumber div(complexNumber c2) {
		complexNumber divNumber = new complexNumber();
		double deno = Math.pow(c2.real, 2) + Math.pow(c2.image, 2);
		try {
			if (deno != 0) {
				divNumber.real = (double) Math.round(((this.real * c2.real + this.image * c2.image) / deno) * 100) / 100;
				divNumber.image = (double) Math.round(((this.image * c2.real - this.real * c2.image) / deno) * 100) / 100;
				return divNumber;
			} else throw new Exception("Invalid...");
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
			return null;
		}
	}
}
