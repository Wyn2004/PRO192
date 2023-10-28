package Module;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

public class StudentList {

	private List<Student> listStudent = new ArrayList<>();

	public StudentList(List<Student> list) {
		this.listStudent = list;
	}

	public StudentList() {
		try {
			loadData();
		} catch (FileNotFoundException e) {
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
				Date dob = Validator.parseDate(tokens[3].trim());
				String gender = tokens[4].trim();

				Student student = new Student(studentID, firstName, lastName, dob, gender);
				this.listStudent.add(student);
				Collections.sort(listStudent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void add() {

		String ID = Validator.inputString("Enter ID student: ").toUpperCase();
		String firstName = Validator.inputString("Enter first name: ");
		String lastName = Validator.inputString("Enter last name: ");
		Date dob = Validator.inputDate("Enter date of birth (dd/MM/yyyy): ");
		String gender = Validator.inputString("Enter gender (male/female): ");

		Student newStudent = new Student(ID, firstName, lastName, dob, gender);
		this.listStudent.add(newStudent);
		Collections.sort(listStudent);
	}

	public void displayListStudent(List<Student> list) {
		if (!this.listStudent.isEmpty()) {
			for (Student student : list) {
				System.out.println(student.toString());
			}
			System.out.println("Total " + list.size() + " student in list.");
		} else
			System.err.println("List student is empty!!!");
	}

	public void seachStudent(Predicate<Student> p)	{
        List<Student> findStudents = new ArrayList<>();
        for (Student student : listStudent) {
            if (p.test(student)) {
                findStudents.add(student);
            }
        }
        displayListStudent(findStudents);
	}
}
