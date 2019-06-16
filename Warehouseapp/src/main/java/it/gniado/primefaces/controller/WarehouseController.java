package it.gniado.primefaces.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import it.gniado.primefaces.dbo.Users;
import it.gniado.primefaces.dbo.Warehouse;
import it.gniado.primefaces.service.UserService;
import it.gniado.primefaces.service.WarehouseService;

@ManagedBean(name= "warehouseController")
@SessionScoped
public class WarehouseController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6495420803069357117L;
	
	private String name;
	private String location;
	
	@Inject
    private WarehouseService warehouseService;

    @Inject
    private NavigationController navigationController;
    
    @Inject
    private UserService userService;
    
    public String save() {
    	Warehouse warehouse = new Warehouse();
    	warehouse.setName(name);
    	warehouse.setLocation(location);
    	Users loggedUser = userService.findUserByName(getUserName());
    	loggedUser.setWarehouse(warehouse);
    	warehouse.getUsers().add(loggedUser);
    	warehouseService.saveWarehouse(warehouse, loggedUser);
    	return navigationController.homePage();
    }
    
    public String getUserName() {
    	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    	String userName = (String) session.getAttribute("user");
    	return userName;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public NavigationController getNavigationController() {
		return navigationController;
	}

	public void setNavigationController(NavigationController navigationController) {
		this.navigationController = navigationController;
	}

}
