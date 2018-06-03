package dao;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Account;
import model.BudgetTable;
import model.TableType;

@Stateless
public class AccountDao {

	@PersistenceContext(unitName = "budgetBuddyJTA")
	private EntityManager em;

	public void test() {
//		long id = 2;
//		Account a = em.find(Account.class, id);
		// ArrayList<BudgetTable> ownedTables = new ArrayList<>();
		// BudgetTable budgetTable = new BudgetTable();
		// budgetTable.setName("table_2");
		// budgetTable.setDescription("desc_2");
		// ownedTables.add(budgetTable);
		// a.setOwnedTables(ownedTables);
		// em.persist(a);

	}

	public void createAccount(Account account) {
		// if(account.isValid()) {
		ArrayList<BudgetTable> ownedTables = new ArrayList<>();
		BudgetTable budgetTable = new BudgetTable();
		budgetTable.setName("table_" + account.getName());
		budgetTable.setDescription("desc_" + account.getName());
		budgetTable.setType(TableType.PERSONAL);
		ownedTables.add(budgetTable);
		account.setOwnedTables(ownedTables);
		em.persist(account);
		// }

	}

	public void udpateAccount(Account account) {
		if (account.isValid()) {
			em.merge(account);
		}

	}

	public Account getAccountByMail(String email) {
		Account user = em.createNamedQuery("findAccountByMail", Account.class).setParameter("email", email)
				.getSingleResult();
		return user;
	}

}
