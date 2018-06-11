package services;

import java.io.File;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import dao.BudgetDao;
import model.BudgetItem;
import model.BudgetTable;
import utils.CSVGenerator;

@Path("items")
@Consumes(MediaType.APPLICATION_JSON)
public class BudgetResource {

	@Inject
    private BudgetDao budgetDao;
	
	@GET
	@Path("/{tableId}/report")
	@Produces("text/csv")
	public Response get(@PathParam("tableId") long tableId){
		return budgetDao.getReportPerTable(tableId);
	}
	
	@POST
	@Path("/{tableId}/add")
	@Produces(MediaType.APPLICATION_JSON)
	public BudgetTable addItem(@PathParam("tableId") long tableId, BudgetItem item){
		return budgetDao.addItem(tableId, item);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public BudgetItem updateItem(BudgetItem item){
		return budgetDao.updateItem(item);
	}
	
	@DELETE
	@Path("/{tableId}/delete/{itemId}")
	public void delete(@PathParam("tableId") long tableId, @PathParam("itemId") long itemId){
		budgetDao.deleteItem(tableId,itemId);
	}
	
}
