package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AccountDao {
	@PersistenceContext(unitName="budgetBuddyJTA")
    private EntityManager em;
	
	
}
