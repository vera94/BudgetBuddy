package model;

import java.util.ArrayList;

public class Account {
	
	private long id;
	
	private String name;
	
	private String password;
	
	private Role role;
	
	private ArrayList<Integer> assignedTables;

	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public ArrayList<Integer> getAssignedTables() {
		return assignedTables;
	}

	public void setAssignedTables(ArrayList<Integer> assignedTables) {
		this.assignedTables = assignedTables;
	} 
}
