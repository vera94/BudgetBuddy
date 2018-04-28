package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
})
public class BudgetTable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	long id;
	
	String name;
	
	String description;
	
	@Enumerated(EnumType.STRING)
	TableType type;
	
	@ManyToMany(cascade = CascadeType.ALL)
	List<Account> owners;
	
	@ManyToMany(cascade = CascadeType.ALL)
	List<Account> shares;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TableType getType() {
		return type;
	}

	public void setType(TableType type) {
		this.type = type;
	}

	public List<Account> getOwners() {
		return owners;
	}

	public void setOwners(List<Account> owners) {
		this.owners = owners;
	}

	public List<Account> getShares() {
		return shares;
	}

	public void setShares(List<Account> shares) {
		this.shares = shares;
	}


}
