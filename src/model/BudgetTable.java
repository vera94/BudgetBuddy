package model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement
public class BudgetTable implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -6249601752705357364L;
	
	public BudgetTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private String description;
	
	@Enumerated(EnumType.STRING)
	private TableType type;
	
//	@ManyToMany(cascade = CascadeType.ALL, mappedBy="ownedTables")
//	private ArrayList<Account> owners;
//	
//	@ManyToMany(cascade = CascadeType.ALL)
//	private ArrayList<Account> shares;
	
	@OneToMany(cascade = CascadeType.ALL)
	private ArrayList<BudgetItem> items;

	@Override
	public String toString() {
		return "BudgetTable [id=" + id + ", name=" + name + ", description=" + description + ", type=" + type
				+ ", items=" + items + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

//	public ArrayList<Account> getOwners() {
//		return owners;
//	}
//
//	public void setOwners(ArrayList<Account> owners) {
//		this.owners = owners;
//	}
//
//	public ArrayList<Account> getShares() {
//		return shares;
//	}
//
//	public void setShares(ArrayList<Account> shares) {
//		this.shares = shares;
//	}

	public ArrayList<BudgetItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<BudgetItem> items) {
		this.items = items;
	}

	public BudgetTable addItem(BudgetItem item) {
		items.add(item);		
		return this;
	}


}
