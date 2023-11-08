package view;

import java.util.List;

public class SchoolView {

	public static <E,T> void displaySchool(List<E> students, List<T> lectors)	{
		
		System.out.println("List students: ");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (E e : students) {
			System.out.println(e.toString());
		}
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Total " + students.size() + " students in list.");
		System.out.println();
		
		System.out.println("List lectors: ");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (T t : lectors) {
			System.out.println(t.toString());
		}
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Total " + lectors.size() + " lectors in list.");

	}
}
