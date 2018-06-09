package model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	
	private String comment;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private BudgetCategory category;
	
	private long value;
	
	@Enumerated(EnumType.STRING)
	private ItemType type;
	
	private Timestamp date;

	@Override
	public String toString() {
		return "BudgetItem [id=" + id + ", name=" + name + ", comment=" + comment + ", category=" + category + ", value=" + value + ", type="
				+ type + ", date=" + date + "]";
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}	
	
}
