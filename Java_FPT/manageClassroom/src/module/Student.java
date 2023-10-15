package module;

public class Student {
	private String fullname;
	private int age;
	private String address;
	private Date date;

	public Student() {
	}

	public Student(String fullname, int age, String address, Date date) {
		this.fullname = fullname;
		this.age = age;
		this.address = address;
		this.date = date;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Student [fullname=" + fullname + ", age=" + age + ", address=" + address + ", date=" + date + "]";
	}

}
