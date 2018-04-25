package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BudgetDao {

	@PersistenceContext(unitName="budgetBuddyJTA")
    private EntityManager em;
	
	public void createTable() {
		//TODO
	}
}
