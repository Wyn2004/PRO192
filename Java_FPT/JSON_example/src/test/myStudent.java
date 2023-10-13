package test;

public class myStudent {

	private String name;
	private int age;
	private String schoolString;
	
	
	
	public myStudent() {

	}



	public myStudent(String name, int age, String schoolString) {
		this.name = name;
		this.age = age;
		this.schoolString = schoolString;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getSchoolString() {
		return schoolString;
	}



	public void setSchoolString(String schoolString) {
		this.schoolString = schoolString;
	}



	@Override
	public String toString() {
		return "myStudent [name=" + name + ", age=" + age + ", schoolString=" + schoolString + "]";
	}
	
	
}
