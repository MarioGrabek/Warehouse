package it.gniado.primefaces.service;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.Dependent;

import it.gniado.primefaces.dao.ComodityDao;
import it.gniado.primefaces.dao.UserDao;
import it.gniado.primefaces.dao.WarehouseDao;
import it.gniado.primefaces.dbo.Comodity;
import it.gniado.primefaces.dbo.Users;
import it.gniado.primefaces.dbo.Warehouse;

@Dependent
public class ComodityService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 31276789362906222L;
	
	@EJB
	private ComodityDao comodityDao;
	
	@EJB
	private UserDao userDao;
	
	public void saveComodity (Comodity comodity, Users user) {
		comodityDao.save(comodity);
		userDao.update(user);
		
	}

}
