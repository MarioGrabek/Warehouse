package it.gniado.primefaces.service;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.Dependent;

import it.gniado.primefaces.dao.UserDao;
import it.gniado.primefaces.dao.WarehouseDao;
import it.gniado.primefaces.dbo.Users;
import it.gniado.primefaces.dbo.Warehouse;

@Dependent
public class WarehouseService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5579683994542052632L;
	
	@EJB
	private WarehouseDao warehouseDao;
	
	@EJB
	private UserDao userDao;
	
	public void saveWarehouse (Warehouse warehouse, Users user) {
		warehouseDao.save(warehouse);
		userDao.update(user);
	}
	

}