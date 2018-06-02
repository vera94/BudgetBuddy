package services;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import dao.BudgetDao;
import model.Account;
import model.BudgetItem;
import model.BudgetTable;

@Path("items")
@Consumes("application/json")
public class BudgetResource {

	@Inject
    private BudgetDao budgetDao;
	
	@POST
	@Path("/{tableId}/add")
	public BudgetTable addItem(@PathParam("tableId") long tableId, BudgetItem item){
		return budgetDao.addItem(tableId, item);
	}
	
	@PUT
	public BudgetItem updateItem(BudgetItem item){
		return budgetDao.updateItem(item);
	}
	
	@DELETE
	@Path("/{itemId}")
	public void updateItem(@PathParam("itemId") long itemId){
		budgetDao.deleteItem(itemId);
	}
	
}
