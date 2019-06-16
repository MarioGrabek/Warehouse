package it.gniado.primefaces.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import it.gniado.primefaces.dbo.EmailAddress;

@Stateless
@LocalBean
public class EmailAddressDao implements SimpleDao<EmailAddress>{
	
	@PersistenceContext(name = "MSSQLDatabase")
	private EntityManager em;

	@Override
	public EmailAddress save(EmailAddress entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public List<EmailAddress> getAll() {
        TypedQuery<EmailAddress> query = em.createQuery("SELECT e FROM EmailAddress e", EmailAddress.class);
        return query.getResultList();
	}

	@Override
	public EmailAddress getBySingleId(Long id) {
		try {
	        TypedQuery<EmailAddress> query = em.createQuery("SELECT e FROM EmailAddress e WHERE e.id = :id", EmailAddress.class);
	        query.setParameter("id", id);
	        return query.getSingleResult();
		} catch (NoResultException ex) {
			System.out.println("Nie znaleziono adresu email o id " + id);
			return null;
		}
	}

	@Override
	public EmailAddress update(EmailAddress entity) {
        em.merge(entity);
        return entity;
	}

	@Override
	public void delete(EmailAddress entity) {
        em.remove(entity);
	}
	
	

}
