package Controller;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Module.Subject;

public class SubjectController implements IFileInfo {

	private List<Subject> subjectList = new ArrayList<>();

	public SubjectController() {
		try {
			readFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public SubjectController(List<Subject> subjectList) {
		this.subjectList = subjectList;
	}

	public List<Subject> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<Subject> subjectList) {
		this.subjectList = subjectList;
	}

	public boolean searchID(String id) {

		if (!subjectList.isEmpty()) {
			for (Subject subject : subjectList) {
				if (subject.getID().equalsIgnoreCase(id))
					return true;
			}
			return false;
		} else
			return false;
	}

	public void add() {

		String mess = "Enter ID subject: ";
		String id;
		while (true) {
			id = Util.Validator.inputString(mess).toUpperCase();
			if (!searchID(id))
				break;
			else
				mess = "This ID is exist, please enter ID subject again: ";
		}
		String name = Util.Validator.inputString("Enter subject name: ");
		int credits = Util.Validator.inputInt("Enter credits name: ", 1, Integer.MAX_VALUE);
		String professor = Util.Validator.inputString("Enter professor: ");

		Subject subject = new Subject(id, name, credits, professor);
		subjectList.add(subject);
		System.out.println("Added successfully!!!!");
	}

	@Override
	public void readFile() throws IOException {
		FileReader fr = new FileReader("Subjects.txt");
		try (BufferedReader reader = new BufferedReader(fr)) {
			String line;
			while ((line = reader.readLine()) != null) {

				String[] tokens = line.split("[,|=]");
				String id = tokens[1].trim();
				String name = tokens[3].trim();
				int credits = Integer.parseInt(tokens[5].trim());
				String professor = tokens[7].trim();

				Subject subject = new Subject(id, name, credits, professor);
				this.subjectList.add(subject);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void writeFile() throws IOException {
		FileOutputStream fos = new FileOutputStream("Subject_Output.txt");
		for (Subject subject : subjectList)
			fos.write((subject.toString() + "\n").getBytes());
		System.out.println("Export data subject done!!!");
		fos.close();
	}

}
