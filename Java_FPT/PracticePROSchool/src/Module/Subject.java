package Module;

import java.util.Objects;

public class Subject {

	private String ID;
	private String name;
	private int credits;
	private String professor;
	
	public Subject(String iD, String name, int credits, String professor) {
		
		this.ID = iD;
		this.name = name;
		this.credits = credits;
		this.professor = professor;
	}

	public Subject() {

	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		return Objects.equals(ID, other.ID) && credits == other.credits && Objects.equals(name, other.name)
				&& Objects.equals(professor, other.professor);
	}

	@Override
	public String toString() {
		return "Subject{ID=" + ID + ", name=" + name + ", credits=" + credits + ", professor=" + professor + "}";
	}
	
}
