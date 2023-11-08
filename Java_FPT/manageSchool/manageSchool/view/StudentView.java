package view;

import java.util.List;

public class StudentView {

	public static <E> void displayStudent(List<E> students) {

		System.out.println("List students: ");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (E e : students) {
			System.out.println(e.toString());
		}
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Total " + students.size() + " students in list.");
		System.out.println();
	}
	
	public static <E> void displayStudentScholarship(List<E> students) {

		System.out.println("List students have scholarship: ");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (E e : students) {
			System.out.println(e.toString());
		}
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Total " + students.size() + " students have scholarship in list.");
		System.out.println();
	}
}
