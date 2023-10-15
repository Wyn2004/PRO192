package module;

import java.io.Serializable;

import com.google.gson.annotations.Expose;

public class School implements Serializable {

	@Expose
	private ListStudent student_list = new ListStudent();
	@Expose
	private ListLector lector_list = new ListLector();

	public School() {
	}

	public School(ListStudent student_list, ListLector lector_list) {
		this.student_list = student_list;
		this.lector_list = lector_list;
	}

	public ListStudent getStudent_list() {
		return student_list;
	}

	public void setStudent_list(ListStudent student_list) {
		this.student_list = student_list;
	}

	public ListLector getLector_list() {
		return lector_list;
	}

	public void setLector_list(ListLector lector_list) {
		this.lector_list = lector_list;
	}

	public void display() {

		for (Student student : getStudent_list().getList()) {
			student.showInfo();
		}

		System.out.println();
		for (Lector lector : getLector_list().getList()) {
			lector.showInfo();
		}
	}

}
