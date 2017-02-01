package com.test.java;

public class TestRecursion {
	
	 int fact(int n) {
		 int result;
		        if(n==1) {
		        	return 1;
		        }
		        System.out.println(n);
		        result = fact(n-1) * n;
		        System.out.println("new" + n);
		        return result;
		 }
	 
	 public static void main(String[] args) {
			// TODO Auto-generated method stub

			/*Object1 obj = new Object1();
			System.out.println(obj);*/
			
			//public static void main(String args[]) {
		 		TestRecursion f = new TestRecursion();
			       System.out.println("Factorial of 3 is " + f.fact(3));
			       System.out.println("Factorial of 4 is " + f.fact(4));
			       System.out.println("Factorial of 5 is " + f.fact(5));
	}

}
