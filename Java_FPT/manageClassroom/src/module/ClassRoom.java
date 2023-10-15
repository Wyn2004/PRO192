package module;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ClassRoom {
	// dat ten bien trung key trong chuoi json
	String classname;
	String address;
	Teacher teacher= new Teacher();;

	@SerializedName("student_list")
	List<Student> student_list= new ArrayList<>();;
	
	public ClassRoom() {

	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Student> getStudentList() {
		return student_list;
	}

	public void setStudentList(List<Student> studentList) {
		this.student_list = studentList;
	}

	public void display() {
		System.out.println("Class Name: " + classname + ", Address: " + address);
		System.out.println(teacher);

		for (Student student : student_list) {
			System.out.println(student);
		}
	}
}
