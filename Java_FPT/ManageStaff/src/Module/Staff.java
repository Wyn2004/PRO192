package Module;

public class Staff {

	private String staffID;
	private String fullName;
	private String department;
	private String password;

	public Staff() {

	}

	public Staff(String staffID, String fullName, String department, String password) {
		this.staffID = staffID;
		this.fullName = fullName;
		this.department = department;
		this.password = password;
	}

	public String getStaffID() {
		return staffID;
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return staffID + ", " + fullName + ", " + department + ", " + password;
	}

	public void changePassword(String oldPass, String newPass) {

		if (this.password.equals(oldPass)) {
			this.password = newPass;
			System.out.println("Change password successfully!!!");
		} else
			System.err.println("Old password is incorrect, change password failed!!!");
	}

}
