package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dto.TableDTO;
import model.Account;

@Stateless
public class TableDao {

	@PersistenceContext(unitName = "budgetBuddyJTA")
	private EntityManager em;

	public TableDTO getTablesPerUser(Account account) {
		// TODO Auto-generated method stub
		return null;
	}



}
