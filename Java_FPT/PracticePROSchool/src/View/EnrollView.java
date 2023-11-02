package View;

import java.util.List;

import Module.Enroll;

public class EnrollView {
	
	public static void displayEnrollList(List<Enroll> list) {

		if (!list.isEmpty()) {
			System.out.println("List enroll:");
			System.out.println("--------------------------------------------------------------");

			for (Enroll enroll : list)
				System.out.println(enroll.toString());

			System.out.println("--------------------------------------------------------------");
			System.out.println("Totol " + list.size() + " enroll in list.");
		} else
			System.out.println("List enroll is empty!!!");
	}
}
