package it.gniado.primefaces.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import it.gniado.primefaces.dbo.Comodity;

@Stateless
@LocalBean
public class ComodityDao implements SimpleDao<Comodity> {
	
	@PersistenceContext(name = "MSSQLDatabase")
	private EntityManager em;
	
	@Override
	public Comodity save(Comodity comodity) {
		em.persist(comodity);
		return comodity;
	}

	@Override
	public List<Comodity> getAll(){
		TypedQuery<Comodity> query = em.createQuery("SELECT u FROM Comodity c", Comodity.class);
		return query.getResultList();
	}

	@Override
	public Comodity getBySingleId(Long id) {
		try {
			TypedQuery<Comodity> query = em.createQuery("SELECT u FROM Comodity c WHERE u.id = :id", Comodity.class);
			query.setParameter("id", id);
			return query.getSingleResult();
		} catch (NoResultException ex) {
			System.out.println("Nie znaleziono zapasu o id " + id);
			return null;
		}
	}
	

	@Override
	public Comodity update(Comodity comodity) {
		em.merge(comodity);
		return comodity;
	}

	@Override
	public void delete(Comodity comodity) {
		em.remove(comodity);
		
	}
	public List<Comodity> getUsersComodity (Long userId){
		TypedQuery<Comodity> query = em.createQuery("SELECT w FROM Comodity c JOIN c.users u WHERE u.id = :id", Comodity.class);
		query.setParameter("id", userId);
		return query.getResultList();
	}

}
