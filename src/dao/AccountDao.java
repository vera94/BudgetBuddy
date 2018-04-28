package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import dto.TableDTO;
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

	public TableDTO getTablesPerUser(long userId) {
		Account account = em.find(Account.class, userId);
		if(account == null) {
			new EntityNotFoundException("The user with id: " +  userId + " does not exist");
		}
		TableDTO tableDto = new TableDTO();
		tableDto.setOwnedTables(account.getOwnedTables());
		tableDto.setSharedTables(account.getSharedTables());
		return tableDto;
	}

	
}
