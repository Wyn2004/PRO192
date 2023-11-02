package View;

import java.util.List;

import Module.Student;

public class StudentView {

	public static void displayStudentList(List<Student> list) {

		if (!list.isEmpty()) {
			System.out.println("List student:");
			System.out.println("--------------------------------------------------------------");

			for (Student student : list)
				System.out.println(student.toString());

			System.out.println("--------------------------------------------------------------");
			System.out.println("Totol " + list.size() + " student in list.");
		} else
			System.out.println("List student is empty!!!");
	}
}
