package Controller;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Module.Student;

public class StudentController implements IFileInfo {

	private List<Student> studentList = new ArrayList<>();

	public StudentController() {
		try {
			readFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public StudentController(List<Student> studentList) {
		this.studentList = studentList;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public boolean searchID(String id) {

		if (!studentList.isEmpty()) {
			for (Student student : studentList) {
				if (student.getID().equalsIgnoreCase(id))
					return true;
			}
			return false;
		} else
			return false;
	}

	public void add() {

		String mess = "Enter ID student: ";
		String id;
		while (true) {
			id = Util.Validator.inputString(mess).toUpperCase();
			if (!searchID(id))
				break;
			else
				mess = "This ID is exist, please enter ID student again: ";
		}
		String firsName = Util.Validator.inputString("Enter first name: ");
		String lastName = Util.Validator.inputString("Enter last name: ");
		String phoneNum = Util.Validator.inputString("Enter phone number: ");
		String adress = Util.Validator.inputString("Enter adress: ");

		Student student = new Student(id, firsName, lastName, phoneNum, adress);
		studentList.add(student);
		System.out.println("Added successfully!!!!");
	}

	@Override
	public void readFile() throws IOException {
		FileReader fr = new FileReader("Students.txt");
		try (BufferedReader reader = new BufferedReader(fr)) {
			String line;
			while ((line = reader.readLine()) != null) {

				String[] tokens = line.split("[,|=]");
				String studentID = tokens[1].trim();
				String firstName = tokens[3].trim();
				String lastName = tokens[5].trim();
				String phoneNum = tokens[7].trim();
				String adress = tokens[9].trim();

				Student student = new Student(studentID, firstName, lastName, phoneNum, adress);
				this.studentList.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void writeFile() throws IOException {
		FileOutputStream fos = new FileOutputStream("Student_Output.txt");
		for (Student student : studentList)
			fos.write((student.toString() + "\n").getBytes());
		System.out.println("Export data student done!!!");
		fos.close();
	}

}
