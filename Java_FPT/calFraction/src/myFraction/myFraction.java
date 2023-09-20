package myFraction;

public class myFraction {
	private int numenator;
	private int denominator;

	public myFraction(int numenator, int denominator) {
		this.numenator = numenator;
		try {
			if (denominator == 0)
				throw new Exception("Invalid denominator");
			else
				this.denominator = denominator;
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
		compactFraction();
	}

	public int getNumenator() {
		return numenator;
	}

	public void setNumenator(int numenator) {
		this.numenator = numenator;
		compactFraction();
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		try {
			if (denominator == 0)
				new Exception("Invalid denominator...");
			else
				this.denominator = denominator;
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
		compactFraction();
	}

	// Compact fraction
	public void compactFraction() {

		// Check zero fraction
		if (this.numenator == 0) {
			this.numenator = 0;
			this.denominator = 1;
		} else {
			// Mark correction
			if (this.denominator < 0) {
				this.denominator = Math.abs(this.denominator);
				this.numenator = -this.numenator;
			}

			// Compact
			int a = Math.abs(this.numenator), b = Math.abs(this.denominator);
			while (a != b) {
				if (a > b)
					a -= b;
				else
					b -= a;
			}
			this.numenator /= a;
			this.denominator /= b;
		}
	}

	// Sum two fraction
	public myFraction sumTwoFraction(myFraction f2) {
		int sumNumenator = this.getNumenator() * f2.getDenominator() + f2.getNumenator() * this.getDenominator();
		int sumDenominator = this.getDenominator() * f2.getDenominator();
		myFraction sumFraction = new myFraction(sumNumenator, sumDenominator);
		sumFraction.compactFraction();
		return sumFraction;
	}

	// Minus two fraction
	public myFraction minusTwoFraction(myFraction f2) {
		int minusNumenator = this.getNumenator() * f2.getDenominator() - f2.getNumenator() * this.getDenominator();
		int minusDenominator = this.getDenominator() * f2.getDenominator();
		myFraction minusFraction = new myFraction(minusNumenator, minusDenominator);
		minusFraction.compactFraction();
		return minusFraction;
	}

	// Multiply two fraction
	public myFraction multiTwoFraction(myFraction f2) {
		int multiNumenator = this.getNumenator() * f2.getNumenator();
		int multiDenominator = this.getDenominator() * f2.getDenominator();
		myFraction multiFraction = new myFraction(multiNumenator, multiDenominator);
		multiFraction.compactFraction();
		return multiFraction;
	}

	// Division two fraction
	public myFraction divTwoFraction(myFraction f2) {
		int divNumenator = this.getNumenator() * f2.getDenominator();
		int divDenominator = this.getDenominator() * f2.getNumenator();
		myFraction divFraction = new myFraction(divNumenator, divDenominator);
		divFraction.compactFraction();
		return divFraction;
	}

	// Fraction to string
	public String toStringFraction() {
		return this.numenator + "/" + this.denominator;
	}
}
