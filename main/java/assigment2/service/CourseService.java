package assigment2.service;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import assigment2.entities.Course;
import assigment2.entities.Teacher;
import assigment2.repositories.CourseRepository;

@Service()
public class CourseService {
	@Inject
	CourseRepository courseRepository;
	
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	public Course getByCourseid(int id) {
		return courseRepository.findCourseBycourseid(id);
	}

	public Course getByName(String name) {
		return courseRepository.findByName(name);
	}

	public Course getByTeacher(Teacher teacher) {
		return courseRepository.findByTeacher(teacher);
	}

	public Course save(Course course) {
		return courseRepository.save(course);
	}

	public void delete(Course course) {
		courseRepository.delete(course);
	}
	public void update(Course course) {
		Course foundCourse = courseRepository.findCourseBycourseid(course.getCourseid());
		foundCourse = course;
		courseRepository.save(foundCourse);
	}
}
