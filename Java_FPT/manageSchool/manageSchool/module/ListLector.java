package module;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.gson.annotations.Expose;

public class ListLector implements Serializable {

	@Expose
	private List<Lector> list = new ArrayList<>();

	public ListLector() {
	}

	public ListLector(List<Lector> list) {
		this.list = list;
	}

	public List<Lector> getList() {
		return list;
	}

	public void setList(List<Lector> list) {
		this.list = list;
	}

	public void printListLector() {
		if (!isEmpty()) {
			System.out.println("List lector: ");
			for (Lector lector : list) {
				lector.showInfo();
			}
		} else
			System.out.println("List lector is empty!!!");
		System.out.println();
	}

	public void add(Lector lector) {
		list.add(lector);
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
		System.out.println("List lector had remove!!!");
	}

	public void removeByID(Lector lID) {
		int count = 0;
		List<Lector> updateListLectors = new ArrayList<>();
		for (Lector lector : list) {
			if (!lector.getID().equals(lID.getID())) {
				updateListLectors.add(lector);
			} else
				count++;
		}
		if (count == 0)
			System.out.println("This ID is not exist!!!");
		else
			System.out.println("Remove done!!");
		this.list = updateListLectors;
		System.out.println();
	}

	public boolean findByID(Lector lID) {
		for (Lector lector : list) {
			if (lector.getID().equals(lector.getID())) {
				lector.showInfo();
				return true;
			}
		}
		return false;
	}

	public boolean findByName(String name) {
		int count = 0;
		for (Lector lector : list) {
			if (lector.getName().equals(name)) {
				count++;
				lector.showInfo();
			}
		}
		return (count == 0) ? false : true;
	}

	public void sortByName() {
		Collections.sort(this.list, new Comparator<Lector>() {

			@Override
			public int compare(Lector l1, Lector l2) {
				return (l1.getName().compareToIgnoreCase(l2.getName()) >= 0) ? 1 : -1;
			}

		});

		for (Lector lector : list) {
			lector.showInfo();
		}
	}
}
