package dto;

import java.util.ArrayList;

import model.Account;
import model.BudgetTable;
import model.TableType;

public class TableDTO {
	
	private ArrayList<BudgetTable> familyTables;
	
	private ArrayList<BudgetTable> personalTables;
	
	private ArrayList<BudgetTable> sharedTables;



	public ArrayList<BudgetTable> getSharedTables() {
		return sharedTables;
	}

	public void setSharedTables(ArrayList<BudgetTable> sharedTables) {
		this.sharedTables = sharedTables;
	}

	public ArrayList<BudgetTable> getFamilyTables() {
		return familyTables;
	}

	public void setFamilyTables(ArrayList<BudgetTable> familyTables) {
		this.familyTables = familyTables;
	}

	public ArrayList<BudgetTable> getPersonalTables() {
		return personalTables;
	}

	public void setPersonalTables(ArrayList<BudgetTable> personalTables) {
		this.personalTables = personalTables;
	}
	
	public void getTablesPerUser(Account account) {
		setFamilyTables(extractTablesPerType(TableType.FAMILY, account.getOwnedTables()));
		setPersonalTables(extractTablesPerType(TableType.PERSONAL, account.getOwnedTables()));
		setSharedTables(account.getSharedTables());
	}

	public void getTablesPerUserAndType(Account account, TableType type) {
		if (type == TableType.FAMILY) {
			setFamilyTables(extractTablesPerType(type, account.getOwnedTables()));
		} else if (type == TableType.PERSONAL) {
			setPersonalTables(extractTablesPerType(type, account.getOwnedTables()));
		}
	}

	private ArrayList<BudgetTable> extractTablesPerType(TableType type, ArrayList<BudgetTable> ownedTables) {
		ArrayList<BudgetTable> result = new ArrayList<BudgetTable>();
		for (BudgetTable budgetTable : ownedTables) {
			if (budgetTable.getType() == type) {
				result.add(budgetTable);
			}
		}
		return result;
	}
}
