package it.gniado.primefaces.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import it.gniado.primefaces.dbo.Users;
import it.gniado.primefaces.service.UserService;

@ManagedBean(name= "usersController")
@SessionScoped

public class UsersController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6985684124996069381L;
	
	@Inject
    private UserService userService;
	
	private List<Users> users;
	

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}
	
	@PostConstruct
	public void init() {
		users = userService.getAllUsers();
	}

}
