package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{
	
	public List<Course> findAll();

}
