package br.com.management.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.management.model.Program;

@Stateless
public class ProgramDaoImpl {

	@Inject
	private EntityManager em;

	private static ProgramDaoImpl programDao;

	private ProgramDaoImpl() {
			
		}

	public static ProgramDaoImpl getInstance() {

		if (programDao == null) {
			programDao = new ProgramDaoImpl();
		}

		return programDao;
	}

	public Program getProgram(Long id) {

		return em.find(Program.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Program> getPrograms() {

		return em.createQuery("FROM Program").getResultList();
	}

	public void saveProgram(Program newProgram) {

		em.persist(newProgram);
	}

	public void updateProgram(Program updatedProgram) {

		em.merge(updatedProgram);
	}

	public void deleteProgram(Long id) {

		Program program = em.find(Program.class, id);
		em.remove(program);
	}
}
