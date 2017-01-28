package com.test.inheritence;

public class Main {

	public static void main(String[] args) {
		
		Department dept1 = new Department();
		System.out.println(dept1.getBudget());
		
		
		Department dept2 = new Department(100);
		System.out.println(dept2.getBudget());
	
		Math m = new Math();
		System.out.println(m.getBudget());
	
		System.out.println(m.getMaxBudget()); //
		
	}

}
