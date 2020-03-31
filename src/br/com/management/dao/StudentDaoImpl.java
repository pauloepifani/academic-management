package br.com.management.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.management.model.Student;

@Stateless
public class StudentDaoImpl {

	@Inject
	private EntityManager em;

	private static StudentDaoImpl studentDao;

	private StudentDaoImpl() {
			
		}

	public static StudentDaoImpl getInstance() {

		if (studentDao == null) {
			studentDao = new StudentDaoImpl();
		}

		return studentDao;
	}

	public Student getStudent(Long id) {

		return em.find(Student.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Student> getStudents() {

		return em.createQuery("FROM Student").getResultList();
	}

	public void saveStudent(Student newStudent) {

		em.persist(newStudent);
	}

	public void updateStudent(Student updatedStudent) {

		em.merge(updatedStudent);
	}

	public void deleteStudent(Long id) {

		Student student = em.find(Student.class, id);
		em.remove(student);
	}
}
