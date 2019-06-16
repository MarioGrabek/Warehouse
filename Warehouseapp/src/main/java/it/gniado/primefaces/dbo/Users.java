package it.gniado.primefaces.dbo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String firstname;
	private String surname;

	@OneToMany(cascade = CascadeType.ALL)
	private List<EmailAddress> emailAddress;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinTable(name = "warehouse_user", joinColumns = @JoinColumn(name ="userId"), inverseJoinColumns = @JoinColumn(name="warehouseId"))
	private Warehouse warehouse;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinTable(name = "comodity_user", joinColumns = @JoinColumn(name ="userId"), inverseJoinColumns = @JoinColumn(name="comodityId"))
	private Comodity comodity;

    public Users() {
        emailAddress = new ArrayList<>();
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public List<EmailAddress> getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(List<EmailAddress> emailAddress) {
        this.emailAddress = emailAddress;
    }

	public String getSurname() {
		return surname;
	}

	public void setSurname(String suername) {
		this.surname = suername;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public Comodity getComodity() {
		return comodity;
	}

	public void setComodity(Comodity comodity) {
		this.comodity = comodity;
	}
}
