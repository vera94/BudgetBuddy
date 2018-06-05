package services;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import dao.AccountDao;
import dto.TableDTO;
import model.Account;
import model.BudgetTable;
import model.TableType;

@Path("/tables")
@Consumes(MediaType.APPLICATION_JSON)
public class TableResource {

	@Context
	private SecurityContext securityContext;

	@Inject
	private AccountDao accountDao;
	
	@GET
	public TableDTO getTablesPerUser() {
		String email = securityContext.getUserPrincipal().getName();
		Account account = accountDao.getAccountByMail(email);
		TableDTO tableDto = new TableDTO();
		tableDto.getTablesPerUser(account);
		return tableDto;
	}

	@GET
	@Path("/{type}")
	public TableDTO getTablesPerUserAndType(@PathParam("type") TableType type) {
		String email = securityContext.getUserPrincipal().getName();
		Account account = accountDao.getAccountByMail(email);
		TableDTO tableDto = new TableDTO();
		tableDto.getTablesPerUserAndType(account, type);
		return tableDto;
	}

	@GET
	@Path("/personal")
	@Produces("application/json")
	public BudgetTable getUserPersonalTable() {
		String email = "admin";//securityContext.getUserPrincipal().getName();
		Account account = accountDao.getAccountByMail(email);
		TableDTO tableDto = new TableDTO();
		tableDto.getTablesPerUserAndType(account, TableType.PERSONAL);
		return tableDto.getPersonalTables().get(0);
	}

}
