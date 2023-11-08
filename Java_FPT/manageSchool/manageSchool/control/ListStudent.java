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
import module.Student;
import utils.Validator;

public class ListStudent implements IFileInfor {

	private static List<Student> list = new ArrayList<>();

	public ListStudent() {
	}

	public ListStudent(List<Student> list) {
		ListStudent.list = list;
	}

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		ListStudent.list = list;
	}

	public void printListStudents(List<Student> list) {
		if (!list.isEmpty()) {
			System.out.println("List students: ");
			System.out.println(
					"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			for (Student student : list) {
				student.showInfo();
			}
			System.out.println(
					"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Total " + list.size() + " students in list.");
		} else
			System.err.println("List student is empty!!!");
		System.out.println();
	}

	public void add() {
		Student student = new Student();
		student.inputInfo();
		list.add(student);
		System.out.println("Done!!!");
		System.out.println();
	}

	public void removeAll() {
		list.removeAll(list);
		System.out.println("List student had remove!!!");
	}

	public static boolean checkID(String oID) {
		if (!list.isEmpty()) {
			for (Student student : list) {
				if (student.getID().equalsIgnoreCase(oID))
					return true;
			}
			return false;
		} else
			return false;
	}

	public static boolean checkEmail(String oEmail) {
		if (!list.isEmpty()) {
			for (Student student : list) {
				if (student.getEmail().equals(oEmail))
					return true;
			}
			return false;
		} else
			return false;
	}

	public void removeStudent(Predicate<Student> p) {
		if (!list.isEmpty()) {
			List<Student> newList = new ArrayList<>();
			for (Student student : list)
				if (!p.test(student))
					newList.add(student);

			if (newList.size() != list.size()) {
				list = newList;
				System.out.println("Remove done!!!");
			} else
				System.err.println("This information is not exist!!!");
		} else
			System.err.println("List student is empty!!!");
	}

	public void searchStudent(Predicate<Student> p) {
		if (!list.isEmpty()) {
			List<Student> searchList = new ArrayList<>();
			for (Student student : list)
				if (p.test(student))
					searchList.add(student);
			if (!searchList.isEmpty())
				printListStudents(searchList);
			else
				System.err.println("This information is not exist!!!");
		} else
			System.err.println("List student is empty!!!");
	}

	public void printScholarShip() {
		int count = 0;
		for (Student student : list) {
			if (student.getAverage() >= 8) {
				student.showInfo();
				count++;
			}
		}
		System.out.println("Have " + count + " student have scholarship.");
	}

	public boolean edit(String id, String phoneNew) {
		for (Student student : list) {
			if (student.getID().equals(id)) {
				student.setPhoneNum(phoneNew);
				return true;
			}
		}
		return false;
	}

	public void sortByName() {
		Collections.sort(ListStudent.list, new Comparator<Student>() {

			@Override
			public int compare(Student st1, Student st2) {
				return (st1.getName().compareToIgnoreCase(st2.getName()) >= 0) ? 1 : -1;
			}

		});
		printListStudents(list);
	}

	public void sortByAverage() {
		Collections.sort(ListStudent.list, new Comparator<Student>() {

			@Override
			public int compare(Student st1, Student st2) {
				return (st1.getAverage() >= st2.getAverage()) ? -1 : 1;
			}
		});
		printListStudents(list);
	}

	@Override
	public void writeFile() throws IOException {
		FileOutputStream fos = new FileOutputStream("Students_Output.txt");
		for (Student student : list)
			fos.write((student.toStringStudent() + "\n").getBytes());
		System.out.println("Export data student done!!!");
		fos.close();
	}

	@Override
	public void readFile() throws IOException {
		FileReader fr = new FileReader("Students_Input.txt");
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
				Double average = Double.parseDouble(tokens[13].trim());
				String email = tokens[15].trim();
				String subject = tokens[17].trim();

				Student student = new Student(name, gender, birthDay, address, phoneNum, id, average, email, subject);
				if (!list.contains(student))
					ListStudent.list.add(student);
			}
			System.out.println("Import data done!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
