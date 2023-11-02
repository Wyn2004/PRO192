package View;

import java.util.List;

import Module.Subject;

public class SubjectView {

	public static void displaySubjectList(List<Subject> list) {

		if (!list.isEmpty()) {
			System.out.println("List subject:");
			System.out.println("--------------------------------------------------------------");

			for (Subject subject : list)
				System.out.println(subject.toString());

			System.out.println("--------------------------------------------------------------");
			System.out.println("Totol " + list.size() + " subject in list.");
		} else
			System.out.println("List subject is empty!!!");
	}
}
