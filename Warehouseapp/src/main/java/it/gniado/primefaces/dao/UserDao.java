package it.gniado.primefaces.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import it.gniado.primefaces.dbo.Users;

@Stateless
@LocalBean
public class UserDao implements SimpleDao<Users> {

	@PersistenceContext(name = "MSSQLDatabase")
	private EntityManager em;

	@Override
	public Users save(Users user) {
		em.persist(user);
		return user;
	}

	@Override
	public List<Users> getAll(){
		TypedQuery<Users> query = em.createQuery("SELECT u FROM Users u", Users.class);
		return query.getResultList();
	}

	@Override
	public Users getBySingleId(Long id) {
		try {
			TypedQuery<Users> query = em.createQuery("SELECT u FROM Users u WHERE u.id = :id", Users.class);
			query.setParameter("id", id);
			return query.getSingleResult();
		} catch (NoResultException ex) {
			System.out.println("Nie znaleziono u¿ytkownika o id " + id);
			return null;
		}
	}
	
	public Users getUserByName(String name) {
		try {
			TypedQuery<Users> query = em.createQuery("SELECT u FROM Users u WHERE u.name = :name", Users.class);
			query.setParameter("name", name);
			return query.getSingleResult();
		} catch (NoResultException ex) {
			System.out.println("Nie znaleziono u¿ytkownika o nazwie " + name);
			return null;
		}
	}

	@Override
	public Users update(Users user) {
		em.merge(user);
		return user;
	}

	@Override
	public void delete(Users entity) {
		em.remove(entity);
		
	}
	
}
