package assigment2.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import assigment2.entities.Course;
import assigment2.entities.Enrollment;
import assigment2.entities.Student;


public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer>{
	public List<Enrollment> findAll();

	public Enrollment findByEnrollmentid(int id);

	public List<Enrollment> findByCourse(Course course);

	public List<Enrollment> findByStudent(Student student);

	public Enrollment save(Enrollment enrollment);

	public void delete(Enrollment enrollment);

	public void deleteByEnrollmentid(int id);
}
