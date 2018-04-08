package services;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/accounts")
public class AccountService {
	
	@GET
	public String hello() {
		Context ctx;
		try {
			System.out.println("Trying to connect");
			ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/budgetbuddy");
			Connection con = ds.getConnection();
			System.out.println(con.getMetaData().getDatabaseProductName());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to make connection with DB");
			
		}
		return "hello";
	}
}
