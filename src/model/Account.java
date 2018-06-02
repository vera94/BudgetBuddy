package model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import static utils.ValidationUtil.*;


@Entity
@NamedQueries({ @NamedQuery(name = "findAccountByMail", query = "SELECT a FROM Account a WHERE a.email = :email")})
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private ArrayList<BudgetTable> ownedTables;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy="shares")
	private ArrayList<BudgetTable> sharedTables;

	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<BudgetTable> getOwnedTables() {
		return ownedTables;
	}

	public void setOwnedTables(ArrayList<BudgetTable> ownedTables) {
		this.ownedTables = ownedTables;
	}

	public ArrayList<BudgetTable> getSharedTables() {
		return sharedTables;
	}

	public void setSharedTables(ArrayList<BudgetTable> sharedTables) {
		this.sharedTables = sharedTables;
	}

	public boolean isValid() {
		return hasValidLength(password, 4, 10) && validate(email, 0 , 30 , VALID_EMAIL_ADDRESS_REGEX) && notNullOrEmpty(name);
	} 
}
