package service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import entities.Student;
import repositories.StudentRepository;

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

	public Student insert(Student student) {
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

}
