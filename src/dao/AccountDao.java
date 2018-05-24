package dao;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import dto.TableDTO;
import model.Account;
import model.BudgetTable;
@Stateless
public class AccountDao {
	
	@PersistenceContext(unitName="budgetBuddyJTA")
    private EntityManager em;

	public void test() {
		Account a = new Account();
		a.setName("name");
		a.setPassword("qwerty");
		ArrayList<BudgetTable> ownedTables = new ArrayList<>();
		BudgetTable budgetTable = new BudgetTable();
		budgetTable.setName("table");
		budgetTable.setDescription("desc");
		ownedTables.add(budgetTable);
		a.setOwnedTables(ownedTables);
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
//		tableDto.setOwnedTables(account.getOwnedTables());
//		tableDto.setSharedTables(account.getSharedTables());
		return tableDto;
	}

	
}
