package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.BudgetItem;
import model.BudgetTable;
import model.TableType;

public class BudgetDao {

	@PersistenceContext(unitName="budgetBuddyJTA")
    private EntityManager em;
	
	public void createTable() {
		//TODO
	}

	public BudgetTable addItem(long tableId, BudgetItem item) {
		BudgetTable budgetTable = em.find(BudgetTable.class, tableId);
		budgetTable.addItem(item);
		return em.merge(budgetTable);
		
	}
	
	public BudgetItem updateItem(BudgetItem item) {
		return em.merge(item);
		
	}

	public BudgetTable getTable(long tableId) {
		return em.find(BudgetTable.class, tableId);
	}
	
	public List<BudgetTable> getOwnedTables(TableType type, String userId){
		return null;
	}

	public void deleteItem(long itemId) {
		BudgetItem budgetItem = em.find(BudgetItem.class, itemId);
		em.remove(budgetItem);
	}
	
	
}
