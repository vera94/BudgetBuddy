package dao;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import model.Account;
import model.BudgetCategory;
import model.BudgetItem;
import model.BudgetTable;
import model.Month;
import model.TableType;
import utils.CSVGenerator;

@Stateless
public class BudgetDao {

	@PersistenceContext(unitName = "budgetBuddyJTA")
	private EntityManager em;

	public void createTable(Account account, BudgetTable table) {
		account.getOwnedTables().add(table);
		em.persist(account);
	}
	
	public void updateTable(BudgetTable table) {
		BudgetTable budgetTable = em.find(BudgetTable.class, table.getId());
		budgetTable.updateProperties(table);
		em.persist(budgetTable);
	}

	public BudgetTable addItem(long tableId, BudgetItem item) {
		if (item.getCategory() != null) {
			long id = item.getCategory().getId();
			if (id != 0) {
				item.setCategory(em.find(BudgetCategory.class, id));
			}
		}
		BudgetTable budgetTable = em.find(BudgetTable.class, tableId);
		em.persist(item);
		budgetTable.addItem(item);
		return em.merge(budgetTable);

	}

	public BudgetItem updateItem(BudgetItem item) {
		BudgetItem itemForUpdate = em.find(BudgetItem.class, item.getId());
		
		long id = item.getCategory().getId();
		if (id != 0 ) {
			item.setCategory(em.find(BudgetCategory.class, id));
		}
		itemForUpdate.mergeProperties(item);
		return em.merge(itemForUpdate);

	}

	public BudgetTable getTable(long tableId) {
		return em.find(BudgetTable.class, tableId);
	}

	public BudgetTable copyTable(Account account, long tableId, Month month) {
		BudgetTable resourceTable = em.find(BudgetTable.class, tableId);
		BudgetTable copiedTable = new BudgetTable(resourceTable);
		for (BudgetItem resourceItem : resourceTable.getItems()) {
			BudgetItem newItem = new BudgetItem(resourceItem);
			Timestamp date = resourceItem.getDate();
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(date.getTime());
			cal.get(Calendar.MONTH);
			cal.set(Calendar.MONTH, month.ordinal() + 1);
			newItem.setDate(new Timestamp(cal.getTimeInMillis()));
		}
		account.getOwnedTables().add(copiedTable);
		em.persist(account);
		return copiedTable;

	}

	public List<BudgetTable> getOwnedTables(TableType type, String userId) {
		return null;
	}

	public void deleteItem(long tableId, long itemId) {
		BudgetTable budgetTable = em.find(BudgetTable.class, tableId);
		ArrayList<BudgetItem> items = budgetTable.getItems();
		for (Iterator<BudgetItem> iterator = items.iterator(); iterator.hasNext();) {
			BudgetItem item = (BudgetItem) iterator.next();
			if (item.getId() == itemId) {
				items.remove(item);
				break;
			}

		}
		em.persist(budgetTable);
		BudgetItem budgetItem = em.find(BudgetItem.class, itemId);
		em.remove(budgetItem);
	}

	public Response getReportPerTable(long tableId) {
		BudgetTable budgetTable = em.find(BudgetTable.class, tableId);
		File file = CSVGenerator.writeToCSV(budgetTable.getItems());
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition", "attachment; filename=\" " + "items" + ".csv\"");
		return response.build();
	}

}
