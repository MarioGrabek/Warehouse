package it.gniado.primefaces.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import it.gniado.primefaces.dbo.Comodity;
import it.gniado.primefaces.dbo.Users;
import it.gniado.primefaces.dbo.Warehouse;
import it.gniado.primefaces.service.ComodityService;
import it.gniado.primefaces.service.UserService;
import it.gniado.primefaces.service.WarehouseService;

@ManagedBean(name= "comodityController")
@SessionScoped
public class ComodityController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5681268738772272484L;
	
	private String name;
	private String amount;
	private String date;
	private String haz;
	
	@Inject
    private ComodityService comodityService;

    @Inject
    private NavigationController navigationController;
    
    @Inject
    private UserService userService;
    
    public String save() {
    	Comodity comodity = new Comodity();
    	comodity.setName(name);
    	comodity.setAmount(amount);
    	comodity.setDate(date);
    	comodity.setHaz(haz);
    	Users loggedUser = userService.findUserByName(getUserName());
    	loggedUser.setComodity(comodity);
    	comodity.getUsers().add(loggedUser);
    	comodityService.saveComodity(comodity, loggedUser);
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

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHaz() {
		return haz;
	}

	public void setHaz(String haz) {
		this.haz = haz;
	}

	public ComodityService getComodityService() {
		return comodityService;
	}

	public void setComodityService(ComodityService comodityService) {
		this.comodityService = comodityService;
	}

	public NavigationController getNavigationController() {
		return navigationController;
	}

	public void setNavigationController(NavigationController navigationController) {
		this.navigationController = navigationController;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
