package model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import static utils.ValidationUtil.*;


@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private ArrayList<BudgetTable> budgetTables;

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

	public ArrayList<BudgetTable> getBudgetTables() {
		return budgetTables;
	}

	public void setBudgetTables(ArrayList<BudgetTable> budgetTables) {
		this.budgetTables = budgetTables;
	}

	public boolean isValid() {
		return hasValidLength(password, 4, 10) && validate(email, 0 , 30 , VALID_EMAIL_ADDRESS_REGEX) && notNullOrEmpty(name);
	} 
}
