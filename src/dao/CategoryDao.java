package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.BudgetCategory;

@Stateless
public class CategoryDao {

	@PersistenceContext(unitName = "budgetBuddyJTA")
	private EntityManager em;

	public List<BudgetCategory> getCategories() {
		return em.createNamedQuery("getAllCategories", BudgetCategory.class).getResultList();
	}


}
