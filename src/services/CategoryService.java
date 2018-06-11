package services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import dao.CategoryDao;
import model.BudgetCategory;

@Path("categories")
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryService {	

	@Context
	private SecurityContext securityContext;

	@Inject
	private CategoryDao categoryDao;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<BudgetCategory> getCategories() {
		return categoryDao.getCategories();
	}
	
	
}
