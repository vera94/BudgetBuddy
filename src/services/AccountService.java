package services;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import dao.AccountDao;
import model.Account;

@Path("/accounts")
public class AccountService {
	
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
	
}
