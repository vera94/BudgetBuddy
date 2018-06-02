package dao;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import dto.TableDTO;
import model.Account;
import model.BudgetTable;
import model.TableType;

@Stateless
public class AccountDao {

	@PersistenceContext(unitName = "budgetBuddyJTA")
	private EntityManager em;

	public void test() {
		long id = 2;
		Account a = em.find(Account.class, id);
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

	public TableDTO getTablesPerUser(String email) {
		Account account = getAccountByMail(email);
		if (account == null) {
			new EntityNotFoundException("The user with email: " + email + " does not exist");
		}
		TableDTO tableDto = new TableDTO();
		tableDto.setFamilyTables(extractTablesPerType(TableType.FAMILY, account.getOwnedTables()));
		tableDto.setPersonalTables(extractTablesPerType(TableType.PERSONAL, account.getOwnedTables()));
		tableDto.setSharedTables(account.getSharedTables());
		return tableDto;
	}

	public TableDTO getTablesPerUserAndType(String email, TableType type) {
		Account account = getAccountByMail(email);
		
		if (account == null) {
			new EntityNotFoundException("The user with email: " + email + " does not exist");
		}
		TableDTO tableDto = new TableDTO();

		

		if (type == TableType.FAMILY) {
			tableDto.setFamilyTables(extractTablesPerType(type, account.getOwnedTables()));
		} else if(type == TableType.PERSONAL) {
			tableDto.setPersonalTables(extractTablesPerType(type, account.getOwnedTables()));
		}
		return tableDto;
	}

	private  ArrayList<BudgetTable> extractTablesPerType(TableType type, ArrayList<BudgetTable> ownedTables) {
		ArrayList<BudgetTable> result = new ArrayList<BudgetTable>();
		for (BudgetTable budgetTable : ownedTables) {
			if (budgetTable.getType() == type) {
				result.add(budgetTable);
			}
		}
		return result;
	}

	public Account getAccountByMail(String email) {
		Account user = em.createNamedQuery("findAccountByMail", Account.class).setParameter("email", email)
				.getSingleResult();
		return user;
	}

}
