package br.com.management.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.management.model.Course;

@Stateless
public class CourseDaoImpl {

	@Inject
	private EntityManager em;

	private static CourseDaoImpl courseDao;

	private CourseDaoImpl() {
			
		}

	public static CourseDaoImpl getInstance() {

		if (courseDao == null) {
			courseDao = new CourseDaoImpl();
		}

		return courseDao;
	}

	public Course getCourse(Long id) {

		return em.find(Course.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Course> getCourses() {

		return em.createQuery("FROM Course").getResultList();
	}

	public void saveCourse(Course newCourse) {

		em.persist(newCourse);
	}

	public void updateCourse(Course updatedCourse) {

		em.merge(updatedCourse);
	}

	public void deleteCourse(Long id) {

		Course course = em.find(Course.class, id);
		em.remove(course);
	}
}
