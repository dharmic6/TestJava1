package com.test.inheritence;

public class Math extends Department{

	public int budget = 500;
	
	public int getMinBudget(){
		return budget;
	}
	
	public int getMaxBudget(){
		return budget + getBudget();
	}
	
}
