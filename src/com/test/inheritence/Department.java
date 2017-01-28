package com.test.inheritence;

public class Department { // Department extends Object

	int budget; 
	
	public Department(){
		this(100);
		System.out.println("In Dept const");
		budget += 500;
	}
	
	public Department(int extraBudget){
		System.out.println("In Dept const with extra Budget");
		budget += extraBudget;
	}
	
	public Department(int eBudget, float extraBudget){
		System.out.println("In Dept const with extra Budget");
		budget += extraBudget;
	}
	
	public int getBudget(){
		return budget;
	}
	
}
