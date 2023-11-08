package view;

import java.util.List;

public class LectorView {

	public static <E> void displayLector(List<E> lectors) {

		System.out.println("List lectors: ");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (E e : lectors) {
			System.out.println(e.toString());
		}
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Total " + lectors.size() + " lectors in list.");
		System.out.println();
	}}
