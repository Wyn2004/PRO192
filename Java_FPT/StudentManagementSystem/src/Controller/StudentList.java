package Controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Module.Validator;

public class StudentList {

	private List<Student> listStudent = new ArrayList<>();
	private Validator validator = new Validator();

	public StudentList(List<Student> list) {
		super();
		this.listStudent = list;
	}

	public StudentList() {
		try {
			loadData();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Student> getList() {
		return listStudent;
	}

	public void setList(List<Student> list) {
		this.listStudent = list;
	}

	public void loadData() throws FileNotFoundException {

		FileReader fr = new FileReader("students.txt");
		try (BufferedReader reader = new BufferedReader(fr)) {
			String line;
			while ((line = reader.readLine()) != null) {

				String[] tokens = line.split(", ");
				String studentID = tokens[0].trim();
				String firstName = tokens[1].trim();
				String lastName = tokens[2].trim();
				String dob = tokens[3].trim();
				String gender = tokens[4].trim();

				Student student = new Student(studentID, firstName, lastName, dob, gender);
				this.listStudent.add(student);
			}
			Collections.sort(listStudent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void add() {

		String ID = this.validator.inputString("Enter ID student: ").toUpperCase();
		String firstName = this.validator.inputString("Enter firse name: ");
		String lastName = this.validator.inputString("Enter last name: ");
		String dob = this.validator.inputString("Enter date of birth: ");
		String gender = this.validator.inputString("Enter gender: ");

		Student newStudent = new Student(ID, firstName, lastName, dob, gender);
		this.listStudent.add(newStudent);
	}

	public void displayListStudent() {

		if (!this.listStudent.isEmpty()) {
			for (Student student : listStudent) {
				System.out.println(student.toString());
			}
			System.out.println("Total " + listStudent.size() + " student in list.");
		} else
			System.err.println("List student is empty!!!");
	}

	public void searchID(String ID) {
		if (!this.listStudent.isEmpty()) {
			for (Student student : listStudent)
				if (student.getStudentID().equalsIgnoreCase(ID)) {
					System.out.println(student.toString());
					return;
				}
			System.err.println("Student with this ID does not exist!!!");
		} else
			System.err.println("List student is empty!!!");
	}
	
	public void searchLastName(String lastName) {
		if (!this.listStudent.isEmpty()) {
			int count = 0;
			for (Student student : listStudent) {
				if (student.getLastName().equalsIgnoreCase(lastName))	{
					count++;
					System.out.println(student.toString());
				}
			}
			System.out.println("Totol "+count+" student with this last name in list.");
		} else
			System.err.println("List student is empty!!!");
	}
	
	public void searchDOB(String DOB) {
		if (!this.listStudent.isEmpty()) {
			int count = 0;
			for (Student student : listStudent) {
				if (student.getDob().equals(DOB))	{
					count++;
					System.out.println(student.toString());
				}
			}
			System.out.println("Totol "+count+" student with this date of birth in list.");
		} else
			System.err.println("List student is empty!!!");
	}
	
	public void searchGender(String gender) {
		if (!this.listStudent.isEmpty()) {
			int count = 0;
			for (Student student : listStudent) {
				if (student.getGender().equalsIgnoreCase(gender))	{
					count++;
					System.out.println(student.toString());
				}
			}
			System.out.println("Totol "+count+" student with this gender in list.");

		} else
			System.err.println("List student is empty!!!");
	}
}
