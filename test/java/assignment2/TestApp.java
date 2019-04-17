package assignment2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import assigment2.entities.Student;
import assigment2.service.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApp {
	@Inject
	StudentService studentService;
	@Test
	public void test() {
		Student student = studentService.getStudentByName("paul19");
		assertThat(student.getName()).isEqualTo("paul19");
		fail("Not yet implemented");
	}

}
