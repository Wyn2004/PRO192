package module;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.gson.annotations.Expose;

public class ListStudent implements Serializable{
	@Expose
	private List<Student> list = new ArrayList<>();

	public ListStudent() {
	}

	public ListStudent(List<Student> list) {
		this.list = list;
	}

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

	public void printListStudents() {
		if (!isEmpty()) {
			System.out.println("List students: ");
			for (Student student : list) {
				student.showInfo();
			}
		} else
			System.out.println("List student is empty!!!");
		System.out.println();
	}

	public void add(Student student) {
		list.add(student);
		System.out.println("Done!!!");
		System.out.println();
	}

	public int getSize() {
		return list.size();
	}

	public Boolean isEmpty() {
		return list.isEmpty();
	}

	public void removeAll() {
		list.removeAll(list);
		System.out.println("List student had remove!!!");
	}

	public void removeByID(Student stdID) {
		int count = 0;
		List<Student> updateListStudent = new ArrayList<>();
		for (Student student : list) {
			if (!student.getID().equals(stdID.getID())) {
				updateListStudent.add(student);
			} else
				count++;
		}
		if (count == 0)
			System.out.println("This ID is not exist!!!");
		else
			System.out.println("Remove done!!");
		this.list = updateListStudent;
		System.out.println();
	}

	public boolean findByID(Student stdID) {
		for (Student student : list) {
			if (student.getID().equals(stdID.getID())) {
				student.showInfo();
				return true;
			}
		}
		return false;
	}

	public boolean findByName(String name) {
		int count = 0;
		for (Student student : list) {
			if (student.getName().equals(name)) {
				count++;
				student.showInfo();
			}
		}
		return (count == 0) ? false : true;
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

	public void sortByName() {
		Collections.sort(this.list, new Comparator<Student>() {

			@Override
			public int compare(Student st1, Student st2) {
				return (st1.getName().compareToIgnoreCase(st2.getName()) >= 0) ? 1 : -1;
			}

		});
		
		for (Student student : list) {
			student.showInfo();
		}
	}

	public void sortByAverage() {
		Collections.sort(this.list, new Comparator<Student>() {

			@Override
			public int compare(Student st1, Student st2) {
				return (st1.getAverage() >= st2.getAverage()) ? -1 : 1;
			}
		});
		
		for (Student student : list) {
			student.showInfo();
		}
	}
	
}
