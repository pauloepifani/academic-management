package br.com.management.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.management.model.Grade;

@Stateless
public class GradeDaoImpl {

	@Inject
	private EntityManager em;

	private static GradeDaoImpl gradeDao;

	private GradeDaoImpl() {
			
		}

	public static GradeDaoImpl getInstance() {

		if (gradeDao == null) {
			gradeDao = new GradeDaoImpl();
		}

		return gradeDao;
	}

	public Grade getGrade(Long id) {

		return em.find(Grade.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Grade> getGrades() {

		return em.createQuery("FROM Grade").getResultList();
	}

	public void saveGrade(Grade newGrade) {

		em.persist(newGrade);
	}

	public void updateGrade(Grade updatedGrade) {

		em.merge(updatedGrade);
	}

	public void deleteGrade(Long id) {

		Grade grade = em.find(Grade.class, id);
		em.remove(grade);
	}
}
