package service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import entities.Student;
import entities.Teacher;
import repositories.StudentRepository;
import repositories.TeacherRepository;

@Service()
public class TeacherService {
	
	@Inject
	TeacherRepository teacherRepository;

	public List<Teacher> getAllTeachers() {
		return teacherRepository.findAll();
	}

	public Teacher getTeacherByName(String name) {
		return teacherRepository.findByName(name);
	}

	public Teacher getTeacherById(int id) {
		return teacherRepository.findTeacherById(id);
	}

	public Teacher insert(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	public void delete(Teacher teacher) {
		teacherRepository.delete(teacher);
	}

	public void update(Teacher teacher) {
		Teacher foundTeacher = teacherRepository.findTeacherById(teacher.getTeacherId());
		foundTeacher = teacher;
		teacherRepository.save(teacher);
	}


}
