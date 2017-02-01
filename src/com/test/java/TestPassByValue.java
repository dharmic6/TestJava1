package com.test.java;

public class TestPassByValue {

	public static void main(String[] args) {
		int a = 20;
		Integer b = 4; 

		System.out.println("Initial Value a: "+a);	
		System.out.println("Initial Value b: "+b);
		
		TestPassByValue t = new TestPassByValue();
		t.changeValue(a);
		t.changeValue(b);
		System.out.println("Final Value a: "+a);	
		System.out.println("Final Value b: "+b);	
	}

	private void changeValue(int a1){
		a1 = 40;
		System.out.println("ChangeValue a: "+a1);	
	}
	
	private void changeValue(Integer a){
		a = 80;
		System.out.println("ChangeValue b: "+a);	
	}
	
}
