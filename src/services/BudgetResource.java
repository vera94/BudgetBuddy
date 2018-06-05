package services;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import dao.BudgetDao;
import model.BudgetItem;
import model.BudgetTable;

@Path("items")
@Consumes(MediaType.APPLICATION_JSON)
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
	@Path("/{tableId}/delete/{itemId}")
	public void delete(@PathParam("tableId") long tableId, @PathParam("itemId") long itemId){
		budgetDao.deleteItem(tableId,itemId);
	}
	
}
