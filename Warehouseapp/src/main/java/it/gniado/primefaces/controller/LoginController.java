package it.gniado.primefaces.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import it.gniado.primefaces.dbo.Users;
import it.gniado.primefaces.service.UserService;

@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = -8702861927269549328L;

	private String name;

    @Inject
    private UserService userService;

    @Inject
    private NavigationController navigationController;

    public String login(){
        Users loggedUser = userService.findUserByName(name);
        if (loggedUser != null){
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("user", name);
            return navigationController.homePage();
        }
        return navigationController.index();
    }

    public String logout(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        return navigationController.index();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
