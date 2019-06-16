package it.gniado.primefaces.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityNotFoundException;

import it.gniado.primefaces.dao.UserDao;
import it.gniado.primefaces.dbo.Users;

@Dependent 
public class UserService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2975476030981443185L;

	@EJB
	private UserDao userDao;
	
	public void saveUser(Users user) {
		userDao.save(user);
	}

	public Users findUserByName(String name){
		return userDao.getUserByName(name);
    }
	
	public List<Users> getAllUsers(){
		return userDao.getAll();
	}
}
