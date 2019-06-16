package it.gniado.primefaces.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import it.gniado.primefaces.dbo.EmailAddress;
import it.gniado.primefaces.dbo.Users;
import it.gniado.primefaces.service.UserService;

@ManagedBean(name = "registrationController")
@SessionScoped
public class RegistrationController implements Serializable{

	private static final long serialVersionUID = -4076842114602305289L;

	private String name;
	private String firstname;
	private String surname;
    private String emailAddress;
    
    
    @Inject
    private UserService userService;

    @Inject
    private NavigationController navigationController;

    public String register(){
        Users user = new Users();
        user.setName(name);
        user.setFirstname(firstname);
        user.setSurname(surname);

        EmailAddress email = new EmailAddress();
        email.setEmailAddress(emailAddress);

        user.getEmailAddress().add(email);
        userService.saveUser(user);

        return navigationController.index();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}
