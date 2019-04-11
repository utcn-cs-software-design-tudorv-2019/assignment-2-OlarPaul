package service;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import entities.Course;
import repositories.CourseRepository;

@Service()
public class CourseService {
	@Inject
	CourseRepository courseRepository;
	
	public List<Course> getAllCourses()
	{
		return courseRepository.findAll();
	}

}
