package com.test.inheritence;

public class Problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int Array[][] = new int[n][n];
		for(int i =0; i<= 4; i++){
			for(int j = 0; j<=i; j++){
				Array[i][j] = j+1;
			}
		}
		for(int i =0; i<= 4; i++){
			for(int j = 0; j<=i; j++){
				System.out.print(Array[i][j]+" ");
			}
			System.out.println(); // Enter Button
		}
		
		

	}

}
