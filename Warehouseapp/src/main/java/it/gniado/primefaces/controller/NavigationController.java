package it.gniado.primefaces.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "navigationController")
@SessionScoped
public class NavigationController implements Serializable {

	private static final long serialVersionUID = 2322058143198784382L;

	public String registration(){
	    return "registration";
    }

    public String login(){
	    return "login";
    }

    public String homePage(){
	    return "homePage";
    }

    public String index(){
        return "index";
	}
    
    public String warehouse(){
    	return "warehouse";
    }
    
    public String comodity(){
    	return "comodity";
    }
    
    public String users() {
    	return "users";
    }
}
