package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
public class BudgetTable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private String description;
	
	@Enumerated(EnumType.STRING)
	private TableType type;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy="ownedTables")
	private List<Account> owners;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Account> shares;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<BudgetItem> items;

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

	public List<BudgetItem> getItems() {
		return items;
	}

	public void setItems(List<BudgetItem> items) {
		this.items = items;
	}


}
