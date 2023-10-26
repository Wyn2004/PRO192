package Module;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StaffList {

	private List<Staff> listStaff = new ArrayList<>();

	public StaffList() {
		try {
			loadData();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public StaffList(List<Staff> listStaff) {
		this.listStaff = listStaff;
	}

	public List<Staff> getListStaff() {
		return listStaff;
	}

	public void setListStaff(List<Staff> listStaff) {
		this.listStaff = listStaff;
	}

	public void loadData() throws FileNotFoundException {

		FileReader fr = new FileReader("staffs.txt");
		try (BufferedReader reader = new BufferedReader(fr)) {
			String line;
			while ((line = reader.readLine()) != null) {

				String[] tokens = line.split(", ");
				String staffID = tokens[0].trim();
				String fullName = tokens[1].trim();
				String department = tokens[2].trim();
				String password = tokens[3].trim();

				Staff staff = new Staff(staffID, fullName, department, password);
				this.listStaff.add(staff);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchByName(String name) {

		if (!this.listStaff.isEmpty()) {
			int count = 0;
			for (Staff staff : listStaff) {
				String fullName = staff.getFullName();
				String subName = fullName.substring(fullName.lastIndexOf(" ") + 1);
				if (subName.equals(name)) {
					System.out.println(staff.toString());
					count++;
				}
			}
			System.out.println("Have " + count + " staff with this name.");
		} else {
			System.err.println("List staff is empty!!");
		}
	}

	public void searchByDepartment(String department) {

		if (!this.listStaff.isEmpty()) {
			int count = 0;
			for (Staff staff : listStaff) {
				if (staff.getDepartment().equals(department)) {
					System.out.println(staff.toString());
					count++;
				}
			}
			System.out.println("Have " + count + " staff with this department.");
		} else {
			System.err.println("List staff is empty!!");
		}
	}

	public Staff searchByID(String ID) {

		if (!this.listStaff.isEmpty()) {
			for (Staff staff : listStaff)
				if (staff.getStaffID().equals(ID))
					return staff;
			return null;
		} else {
			System.err.println("List staff is empty!!");
			return null;
		}
	}

	public boolean login(String ID, String password) {

		if (searchByID(ID) != null) {
			Staff staffUser = searchByID(ID);
			if (staffUser.getPassword().equals(password))
				return true;
			return false;
		} else
			return false;
	}

	public void displayListStaff() {
		if (!this.listStaff.isEmpty()) {
			for (Staff staff : listStaff)
				System.out.println(staff.toString());
			System.out.println("Total " + listStaff.size() + " staff in list.");

		} else {
			System.err.println("List staff is empty!!");
		}
	}
}
