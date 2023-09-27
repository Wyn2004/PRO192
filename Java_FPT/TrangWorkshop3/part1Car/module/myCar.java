package module;

public class myCar {

	private String colour;
	private int engineerPower;
	private boolean convertible;
	private boolean parkingBrake;

	// Constructor empty
	public myCar() {
		this.colour = null;
		this.engineerPower = 0;
		this.convertible = false;
		this.parkingBrake = false;
	}

	// Constructor have data
	public myCar(String colour, int engineerPower, boolean convertible, boolean parkingBrake) {
		this.colour = colour;
		this.engineerPower = engineerPower;
		this.convertible = convertible;
		this.parkingBrake = parkingBrake;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String color) {
		this.colour = color;
	}

	public int getEngineerPower() {
		return engineerPower;
	}

	public void setEngineerPower(int engineerPower) {
		this.engineerPower = engineerPower;
	}

	public boolean isConvertible() {
		return convertible;
	}

	public void setConvertible(boolean convertible) {
		this.convertible = convertible;
	}

	public boolean isParkingBrake() {
		return parkingBrake;
	}

	public void setParkingBrake(boolean parkingBrake) {
		this.parkingBrake = parkingBrake;
	}

	public void pressStarButton() {
		System.out.println("You have pressed the start button!!!");
	}

	public void pressAcceleratorButton() {
		System.out.println("You have pressed the Accelerator button!!!");
	}

	@Override
	public String toString() {
		return "myCar [color=" + colour + ", engineerPower=" + engineerPower + ", convertible=" + convertible
				+ ", parkingBrake=" + parkingBrake + "]";
	}

	public void output() {
		System.out.println(toString());
	}

}
