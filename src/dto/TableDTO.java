package dto;

import java.util.ArrayList;

import model.BudgetTable;

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
}
