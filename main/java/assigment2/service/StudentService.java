package assigment2.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import assigment2.entities.Course;
import assigment2.entities.Student;
import assigment2.repositories.StudentRepository;

@Service()
public class StudentService {

	@Inject
	StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Student getStudentByName(String name) {
		return studentRepository.findByName(name);
	}

	public Student getStudentById(int id) {
		return studentRepository.findStudentById(id);
	}
	
	public Student getStudentByUsername(String username) {
		return studentRepository.findStudentByUsername(username);
	}
	public Student save(Student student) {
		return studentRepository.save(student);
	}

	public void delete(Student student) {
		studentRepository.delete(student);
	}

	public void update(Student oneStudent) {
		Student foundStudent = studentRepository.findStudentById(oneStudent.getStudentById());
		foundStudent = oneStudent;
		studentRepository.save(foundStudent);
	}

	public List<Course> findStudentCourses(int studentById) {
		List<Course> allCourses = new ArrayList<Course>();
		studentRepository.findStudentById(studentById).getEnrollments().stream().forEach(e -> allCourses.add(e.getCourse()));
		return allCourses;
	}

}
