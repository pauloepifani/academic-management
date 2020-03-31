package br.com.management.dao;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class DaoFactory {
	
	@PersistenceContext(unitName = "academic")
	@Produces
	private EntityManager em;

}
