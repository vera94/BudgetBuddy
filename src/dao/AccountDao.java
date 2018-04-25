package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Account;
@Stateless
public class AccountDao {
	
	@PersistenceContext(unitName="budgetBuddyJTA")
    private EntityManager em;

	public void test() {
		Account a = new Account();
		a.setName("name");
		a.setPassword("qwerty");
		em.persist(a);
		
	}

	public void createAccount(Account account) {
		if(account.isValid()) {
			em.persist(account);
		}
		
	}

	public void udpateAccount(Account account) {
		if(account.isValid()) {
			em.merge(account);
		}
		
	}

	
}
