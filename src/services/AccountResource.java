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

@Path("/accounts")
@Consumes("application/json")
@Produces("application/json")
public class AccountResource {
	
	@Inject
    private AccountDao accountDao;
	
	@GET
	public String hello() {
//		Context ctx;
//		try {
//			System.out.println("Trying to connect");
//			ctx = new InitialContext();
//			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/budgetbuddy");
//			Connection con = ds.getConnection();
//			System.out.println(con.getMetaData().getDatabaseProductName());
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Unable to make connection with DB");
//			
//		}
		accountDao.test();
		return "hello";
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
	@Path("/{id}/tables")
	public TableDTO getTablesPerUser(@PathParam("id") long userId){
		return accountDao.getTablesPerUser(userId);
	}
	
}
