package assigment2.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import assigment2.entities.Student;
import assigment2.entities.Teacher;
import assigment2.repositories.StudentRepository;
import assigment2.repositories.TeacherRepository;

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
		return teacherRepository.findTeacherByteacherid(id);
	}

	public Teacher insert(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	public void delete(Teacher teacher) {
		teacherRepository.delete(teacher);
	}

	public void update(Teacher teacher) {
		Teacher foundTeacher = teacherRepository.findTeacherByteacherid(teacher.getTeacherId());
		foundTeacher = teacher;
		teacherRepository.save(teacher);
	}

	public Teacher getTeacherByUsername(String username) {
		return teacherRepository.findByUsername(username);
	}


}
