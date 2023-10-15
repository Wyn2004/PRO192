package module;

public class Teacher {
	String fullname;
	int age;
	String address;

	public Teacher() {
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Teacher{" + "fullname=" + fullname + ", age=" + age + ", address=" + address + '}';
	}
}
