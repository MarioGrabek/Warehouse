package it.gniado.primefaces.dao;

import java.util.List;

public interface SimpleDao<T> {

	T save(T entity);
	
	List<T> getAll();
	
	T getBySingleId(Long id);
	
	T update(T entity);
	
	void delete(T entity);

}
