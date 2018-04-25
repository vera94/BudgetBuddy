package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class BudgetTable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	long id;
	
	String name;
	
	String description;
	
	@Enumerated(EnumType.STRING)
	TableType type;
	
	@ManyToMany(cascade = CascadeType.ALL)
	List<Account> accounts;
}
