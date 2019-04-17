package assigment2.mvc.model;

import assigment2.entities.Student;

public class StudentModel {
	private Student student;

	public StudentModel() {
		this.student = new Student();
	}

	public StudentModel(Student student) {
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
