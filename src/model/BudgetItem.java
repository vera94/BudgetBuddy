package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class BudgetItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5303685752993031389L;

	public BudgetItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private BudgetCategory category;
	
	private long value;
	
	@Enumerated(EnumType.STRING)
	private ItemType type;

	@Override
	public String toString() {
		return "BudgetItem [id=" + id + ", name=" + name + ", category=" + category + ", value=" + value + ", type="
				+ type + "]";
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

	public BudgetCategory getCategory() {
		return category;
	}

	public void setCategory(BudgetCategory category) {
		this.category = category;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public ItemType getType() {
		return type;
	}

	public void setType(ItemType type) {
		this.type = type;
	}	
	
}
