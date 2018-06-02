package services;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import dao.AccountDao;
import dto.TableDTO;
import model.Account;
import model.BudgetItem;
import model.BudgetTable;
import model.TableType;

@Path("/accounts")
@Consumes("application/json")
public class AccountResource {
	
	@Inject
    private AccountDao accountDao;
	
	@GET
	public String hello() {
		Account accountByMail = accountDao.getAccountByMail("admin");
		return "hello";
	}
	
	@GET
	@Path("/{email}")
	public Account getAccountByMail(@PathParam("email") String email) {
		return accountDao.getAccountByMail(email);
	} 
	
	@POST
	public void createAccount(Account account) {
		accountDao.createAccount(account);		
	}	
	
	@PUT 
	public void updateAccount(Account account) {
		accountDao.udpateAccount(account);
	}
	
	@GET
	@Path("/{email}/tables")
	public TableDTO getTablesPerUser(@PathParam("email") String email){
		return accountDao.getTablesPerUser(email);
	}
	
	@GET
	@Path("/{email}/tables/{type}")
	public TableDTO getTablesPerUserAndType(@PathParam("email") String email, @PathParam("type") TableType type){
		return accountDao.getTablesPerUserAndType(email, type);
	}	

	
	@GET
	@Path("/{email}/tables/personal")
	public BudgetTable getUserPersonalTable(@PathParam("email") String email){
		TableDTO tableDTO = accountDao.getTablesPerUserAndType(email, TableType.PERSONAL);
		return tableDTO.getPersonalTables().get(0);
	}


} 

