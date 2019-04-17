package assigment2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import assigment2.entities.Course;
import assigment2.entities.Teacher;

public interface CourseRepository extends JpaRepository<Course, Integer>{
	
	public List<Course> findAll();

	public Course findCourseBycourseid(int id);

	public Course findByName(String name);

	public Course findByTeacher(Teacher teacher);

	@SuppressWarnings("unchecked")
	public Course save(Course course);

	public void delete(Course course);


}
