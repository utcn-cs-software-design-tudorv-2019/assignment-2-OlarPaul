package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer>{
	
	public Teacher findByName(String name);
	
	public Teacher findTeacherById(int id);
	
	public List<Teacher> findAll();
	
	@SuppressWarnings("unchecked")
	public Teacher save(Teacher teacher);
	
	public void delete(Teacher teacher);
}
