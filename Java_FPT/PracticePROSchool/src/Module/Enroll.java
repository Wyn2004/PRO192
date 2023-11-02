package Module;

import java.util.Objects;

public class Enroll {

	private String enrollID;
	private String studentID;
	private String subjectID;
	
	public Enroll(String enrollID, String studentID, String subjectID) {
		this.enrollID = enrollID;
		this.studentID = studentID;
		this.subjectID = subjectID;
	}

	public Enroll() {

	}

	public String getEnrollID() {
		return enrollID;
	}

	public void setEnrollID(String enrollID) {
		this.enrollID = enrollID;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enroll other = (Enroll) obj;
		return Objects.equals(enrollID, other.enrollID) && Objects.equals(studentID, other.studentID)
				&& Objects.equals(subjectID, other.subjectID);
	}

	@Override
	public String toString() {
		return "Enroll{enrollID=" + enrollID + ", studentID=" + studentID + ", subjectID=" + subjectID + "}";
	}
	
	
}
