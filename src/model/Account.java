package model;

import static utils.ValidationUtil.VALID_EMAIL_ADDRESS_REGEX;
import static utils.ValidationUtil.hasValidLength;
import static utils.ValidationUtil.notNullOrEmpty;
import static utils.ValidationUtil.validate;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "findAccountByMail", query = "SELECT a FROM Account a WHERE a.email = :email")})
public class Account implements Serializable{
	
	private static final long serialVersionUID = -2340029740061156573L;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
            name="SharedTables",
            joinColumns = @JoinColumn( name="Account_ID"),
            inverseJoinColumns = @JoinColumn( name="sharedTables_id")
        )
	private ArrayList<BudgetTable> sharedTables;

	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
            name="OwnedTables",
            joinColumns = @JoinColumn( name="Account_ID"),
            inverseJoinColumns = @JoinColumn( name="ownedTables_id")        )
	private ArrayList<BudgetTable> ownedTables;
	
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", sharedTables=" + sharedTables + ", ownedTables=" + ownedTables + "]";
	}


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
	
	//@JohnzonConverter( TableAdapter.class) 
	public ArrayList<BudgetTable> getOwnedTables() {
		return ownedTables;
	}

	public void setOwnedTables(ArrayList<BudgetTable> ownedTables) {
		this.ownedTables = ownedTables;
	}

	//@JohnzonConverter( TableAdapter.class) 
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
