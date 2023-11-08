package control;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import module.IFileInfor;
import module.Lector;
import utils.Validator;
import view.LectorView;

public class ListLector implements IFileInfor {

	private static List<Lector> list = new ArrayList<>();

	public ListLector() {
	}

	public ListLector(List<Lector> list) {
		ListLector.list = list;
	}

	public List<Lector> getList() {
		return list;
	}

	public void setList(List<Lector> list) {
		ListLector.list = list;
	}

	public void printListLector(List<Lector> list) {
		if (!list.isEmpty()) {
			LectorView.displayLector(list);
		} else
			System.err.println("List lectors is empty!!!");
		System.out.println();
	}

	public void add() {
		Lector lector = new Lector();
		lector.inputInfo();
		list.add(lector);
		System.out.println("Done!!!");
		System.out.println();
	}

	public void removeAll() {
		list.removeAll(list);
		System.out.println("List lector had remove!!!");
	}

	public static boolean checkID(String oID) {
		if (!list.isEmpty()) {
			for (Lector lector : list) {
				if (lector.getID().equalsIgnoreCase(oID))
					return true;
			}
			return false;
		} else
			return false;
	}

	public static boolean checkEmail(String oEmail) {
		if (!list.isEmpty()) {
			for (Lector lector : list) {
				if (lector.getEmail().equals(oEmail))
					return true;
			}
			return false;
		} else
			return false;
	}

	public void removeLector(Predicate<Lector> p) {
		if (!list.isEmpty()) {
			List<Lector> newList = new ArrayList<>();
			for (Lector lector : list)
				if (!p.test(lector))
					newList.add(lector);

			if (newList.size() != list.size()) {
				list = newList;
				System.out.println("Remove done!!!");
			} else
				System.err.println("This information is not exist!!!");
		} else
			System.err.println("List lector is empty!!!");

	}

	public void searchLector(Predicate<Lector> p) {
		if (!list.isEmpty()) {
			List<Lector> searchList = new ArrayList<>();
			for (Lector lector : list)
				if (p.test(lector))
					searchList.add(lector);
			if (!searchList.isEmpty())
				printListLector(searchList);
			else
				System.err.println("This information is not exist!!!");
		} else
			System.err.println("List lector is empty!!!");
	}

	public boolean edit(String id, String phoneNew) {
		if (!list.isEmpty()) {
			for (Lector lector : list) {
				if (lector.getID().equals(id)) {
					lector.setPhoneNum(phoneNew);
					return true;
				}
			}
			return false;
		} else
			return false;
	}

	public void sortByName() {
		Collections.sort(ListLector.list, new Comparator<Lector>() {

			@Override
			public int compare(Lector l1, Lector l2) {
				return (l1.getName().compareToIgnoreCase(l2.getName()) >= 0) ? 1 : -1;
			}

		});
		printListLector(list);
	}

	@Override
	public void writeFile() throws IOException {
		FileOutputStream fos = new FileOutputStream("Lectors_Output.txt");
		for (Lector lector : list)
			fos.write((lector.toString() + "\n").getBytes());
		System.out.println("Export data lector done!!!");
		fos.close();
	}

	@Override
	public void readFile() throws IOException {
		FileReader fr = new FileReader("Lectors_Input.txt");
		try (BufferedReader reader = new BufferedReader(fr)) {
			String line;
			while ((line = reader.readLine()) != null) {

				String[] tokens = line.split("[,|=]");
				String name = tokens[1].trim();
				String gender = tokens[3].trim();
				Date birthDay = Validator.parseDate(tokens[5].trim());
				String address = tokens[7].trim();
				String phoneNum = tokens[9].trim();
				String id = tokens[11].trim();
				String email = tokens[13].trim();
				String subject = tokens[15].trim();

				Lector lector = new Lector(name, gender, birthDay, address, phoneNum, id, email, subject);
				if (!list.contains(lector))
					ListLector.list.add(lector);
			}
			System.out.println("Import data done!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
