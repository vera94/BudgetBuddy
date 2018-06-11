package services;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import dao.AccountDao;
import dao.BudgetDao;
import dto.TableDTO;
import model.Account;
import model.BudgetTable;
import model.Month;
import model.TableType;

@Path("/tables")
@Consumes(MediaType.APPLICATION_JSON)
public class TableResource {

	@Context
	private SecurityContext securityContext;

	@Inject
	private AccountDao accountDao;
	
	@Inject
	private BudgetDao budgetDao;
	
	@POST
	public void createTable(BudgetTable table) {
		String email = securityContext.getUserPrincipal().getName();
		Account account = accountDao.getAccountByMail(email);
		budgetDao.createTable(account, table);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public TableDTO updateTable(BudgetTable table) {
		String email = securityContext.getUserPrincipal().getName();
		Account account = accountDao.getAccountByMail(email);
		TableDTO tableDto = new TableDTO();
		tableDto.getTablesPerUser(account);
		return tableDto;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TableDTO getTablesPerUser() {
		String email = securityContext.getUserPrincipal().getName();
		Account account = accountDao.getAccountByMail(email);
		TableDTO tableDto = new TableDTO();
		tableDto.getTablesPerUser(account);
		return tableDto;
	}

	@GET
	@Path("/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	public TableDTO getTablesPerUserAndType(@PathParam("type") TableType type) {
		String email = securityContext.getUserPrincipal().getName();
		Account account = accountDao.getAccountByMail(email);
		TableDTO tableDto = new TableDTO();
		tableDto.getTablesPerUserAndType(account, type);
		return tableDto;
	}

	@GET
	@Path("/personal")
	@Produces(MediaType.APPLICATION_JSON)
	public BudgetTable getUserPersonalTable() {
		String email = securityContext.getUserPrincipal().getName();
		Account account = accountDao.getAccountByMail(email);
		TableDTO tableDto = new TableDTO();
		tableDto.getTablesPerUserAndType(account, TableType.PERSONAL);
		return tableDto.getPersonalTables().get(0);
	}

	@GET
	@Path("/{type}/{month}")
	@Produces(MediaType.APPLICATION_JSON)
	public TableDTO getUserTablePerTypeAndMonth(@PathParam("type") TableType type, @PathParam("month") Month month) {
		String email = securityContext.getUserPrincipal().getName();
		Account account = accountDao.getAccountByMail(email);
		TableDTO tableDto = new TableDTO();
		tableDto.getTablesPerTypeMonth(account, type, month);
		return tableDto;
	}
	
	@POST
	@Path("/copy/{tableId}/{month}")
	public void copyTable(@PathParam("tableId")  long resourceTableId, @PathParam("month")  Month month) {
		String email = securityContext.getUserPrincipal().getName();
		Account account = accountDao.getAccountByMail(email);
		budgetDao.copyTable(account, resourceTableId, month);				
	}
}
