package assigment2.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import assigment2.entities.Course;
import assigment2.entities.Enrollment;
import assigment2.entities.Student;
import assigment2.repositories.EnrollmentRepository;

@Service()
public class EnrollmentService {

	@Inject
	EnrollmentRepository enrollmentRepository;

	public Enrollment insert(Enrollment enrollment) {
		return enrollmentRepository.save(enrollment);
	}

	public Enrollment getByStudentAndCourse(Student student, Course course) {
		List<Enrollment> enrolls = student.getEnrollments();
		enrolls.stream().filter(e -> e.getCourse().getCourseid() == course.getCourseid());
		return enrolls.get(0);
	}

	public List<Enrollment> getByCourse(Course course) {
		return enrollmentRepository.findByCourse(course);
	}

	public void delete(Enrollment enrollment) {
		enrollmentRepository.delete(enrollment);

	}
}
