package assignment2;

import static org.junit.Assert.*;

import entities.Student;
import service.StudentService;

public class Test {

	@org.junit.Test
	public void test() {
		
		Student student = new Student();
		student.setName("Paul");
		student.setEmail("email");
		StudentService studentService = new StudentService();
		studentService.insert(student);
		//fail("Not yet implemented");
	}

}
