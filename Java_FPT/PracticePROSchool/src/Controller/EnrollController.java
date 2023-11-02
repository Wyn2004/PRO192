package Controller;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Module.Enroll;

public class EnrollController implements IFileInfo {

	private List<Enroll> enrollList = new ArrayList<>();

	public EnrollController() {
		try {
			readFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public EnrollController(List<Enroll> subjectList) {
		this.enrollList = subjectList;
	}

	public List<Enroll> getEnrollList() {
		return enrollList;
	}

	public void setEnrollList(List<Enroll> enrollList) {
		this.enrollList = enrollList;
	}

	public boolean searchID(String id) {

		if (!enrollList.isEmpty()) {
			for (Enroll enroll : enrollList) {
				if (enroll.getEnrollID().equalsIgnoreCase(id))
					return true;
			}
			return false;
		} else
			return false;
	}

	public void add() {

		String mess = "Enter ID enroll: ";
		String id;
		while (true) {
			id = Util.Validator.inputString(mess).toUpperCase();
			if (!searchID(id))
				break;
			else
				mess = "This ID is exist, please enter ID enroll again: ";
		}
		String studentID = Util.Validator.inputString("Enter student id: ");
		String subjectID = Util.Validator.inputString("Enter subject id: ");

		Enroll enroll = new Enroll(id, studentID, subjectID);
		this.enrollList.add(enroll);
		System.out.println("Added successfully!!!!");
	}

	@Override
	public void readFile() throws IOException {
		FileReader fr = new FileReader("Enrolls.txt");
		try (BufferedReader reader = new BufferedReader(fr)) {
			String line;
			while ((line = reader.readLine()) != null) {

				String[] tokens = line.split("[,|=]");
				String id = tokens[1].trim();
				String studentID = tokens[3].trim();
				String subjectID = tokens[5].trim();

				Enroll enroll = new Enroll(id, studentID, subjectID);
				this.enrollList.add(enroll);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void writeFile() throws IOException {
		FileOutputStream fos = new FileOutputStream("Enroll_Output.txt");
		for (Enroll enroll : enrollList)
			fos.write((enroll.toString() + "\n").getBytes());
		System.out.println("Export data enroll done!!!");
		fos.close();
	}

}
