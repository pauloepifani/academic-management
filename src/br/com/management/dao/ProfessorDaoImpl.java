package br.com.management.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.management.model.Professor;

@Stateless
public class ProfessorDaoImpl {

	@Inject
	private EntityManager em;

	private static ProfessorDaoImpl professorDao;

	private ProfessorDaoImpl() {
			
		}

	public static ProfessorDaoImpl getInstance() {

		if (professorDao == null) {
			professorDao = new ProfessorDaoImpl();
		}

		return professorDao;
	}

	public Professor getProfessor(Long id) {

		return em.find(Professor.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Professor> getProfessors() {

		return em.createQuery("FROM Professor").getResultList();
	}

	public void saveProfessor(Professor newProfessor) {

		em.persist(newProfessor);
	}

	public void updateProfessor(Professor updatedProfessor) {

		em.merge(updatedProfessor);
	}

	public void deleteProfessor(Long id) {

		Professor professor = em.find(Professor.class, id);
		em.remove(professor);
	}
}
