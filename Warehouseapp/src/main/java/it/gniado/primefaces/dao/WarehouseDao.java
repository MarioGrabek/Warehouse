package it.gniado.primefaces.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import it.gniado.primefaces.dbo.Warehouse;

@Stateless
@LocalBean
public class WarehouseDao implements SimpleDao<Warehouse> {

	@PersistenceContext(name = "MSSQLDatabase")
	private EntityManager em;

	@Override
	public Warehouse save(Warehouse warehouse) {
		em.persist(warehouse);
		return warehouse;
	}

	@Override
	public List<Warehouse> getAll(){
		TypedQuery<Warehouse> query = em.createQuery("SELECT u FROM Warehouse w", Warehouse.class);
		return query.getResultList();
	}

	@Override
	public Warehouse getBySingleId(Long id) {
		try {
			TypedQuery<Warehouse> query = em.createQuery("SELECT u FROM Warehouse w WHERE u.id = :id", Warehouse.class);
			query.setParameter("id", id);
			return query.getSingleResult();
		} catch (NoResultException ex) {
			System.out.println("Nie znaleziono magazynu o id " + id);
			return null;
		}
	}
	

	@Override
	public Warehouse update(Warehouse warehouse) {
		em.merge(warehouse);
		return warehouse;
	}

	@Override
	public void delete(Warehouse warehouse) {
		em.remove(warehouse);
		
	}
		
	public List<Warehouse> getUsersWarehouse(Long userId){
		TypedQuery<Warehouse> query = em.createQuery("SELECT w FROM Warehouse w JOIN w.users u WHERE u.id = :id", Warehouse.class);
		query.setParameter("id", userId);
		return query.getResultList();
	}
	
}
