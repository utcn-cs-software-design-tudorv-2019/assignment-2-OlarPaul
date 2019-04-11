package repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import entities.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

	public Student findByName(String name);
	
	public Student findStudentById(int id);
	
	public List<Student> findAll();
	
	@SuppressWarnings("unchecked")
	public Student save(Student student);
	
	public void delete(Student student);
}
