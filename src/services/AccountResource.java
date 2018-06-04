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
import model.Account;


@Path("/accounts")
@Consumes(MediaType.APPLICATION_JSON)
public class AccountResource {
	
	
	@Context
    private SecurityContext securityContext;
	
	@Inject
    private AccountDao accountDao;
	
	@GET
	@Produces("application/json")
	public Account hello() {		
		Account accountByMail = accountDao.getAccountByMail("admin");
		return accountByMail;
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
	
} 

