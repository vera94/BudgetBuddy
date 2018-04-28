package dto;

import java.util.ArrayList;

import model.BudgetTable;

public class TableDTO {
	
	private ArrayList<BudgetTable> ownedTables;
	
	private ArrayList<BudgetTable> sharedTables;

	public ArrayList<BudgetTable> getOwnedTables() {
		return ownedTables;
	}

	public void setOwnedTables(ArrayList<BudgetTable> ownedTables) {
		this.ownedTables = ownedTables;
	}

	public ArrayList<BudgetTable> getSharedTables() {
		return sharedTables;
	}

	public void setSharedTables(ArrayList<BudgetTable> sharedTables) {
		this.sharedTables = sharedTables;
	}
}
