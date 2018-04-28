package services;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import dao.BudgetDao;

@Path("tables")
@Consumes("application/json")
@Produces("application/json")
public class BudgetResource {

	@Inject
    private BudgetDao budgetDao;
	

}
