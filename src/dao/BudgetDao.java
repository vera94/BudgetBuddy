package dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import model.BudgetItem;
import model.BudgetTable;
import model.TableType;
import utils.CSVGenerator;

@Stateless
public class BudgetDao {

	@PersistenceContext(unitName="budgetBuddyJTA")
    private EntityManager em;
	
	public void createTable() {
		//TODO
	}

	public BudgetTable addItem(long tableId, BudgetItem item) {
		BudgetTable budgetTable = em.find(BudgetTable.class, tableId);
		em.persist(item);
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

	public void deleteItem(long tableId, long itemId) {
		BudgetTable budgetTable = em.find(BudgetTable.class, tableId);
		ArrayList<BudgetItem> items = budgetTable.getItems();
		for (Iterator<BudgetItem> iterator = items.iterator(); iterator.hasNext();) {
			BudgetItem item = (BudgetItem) iterator.next();
			if(item.getId() == itemId) {
				items.remove(item);
				break;
			}
			
		}
		em.persist(budgetTable);
	}

	public Response getReportPerTable(long tableId) {
		BudgetTable budgetTable = em.find(BudgetTable.class, tableId);
		File file = CSVGenerator.writeToCSV(budgetTable.getItems());
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition", "attachment; filename=\" " + "items" + ".csv\"");	
		return response.build();
	}
	
	
}
