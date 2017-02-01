package com.test.inheritence;

import java.util.Scanner;

public class MissingNumber {

	public static void main(String[] args) {
		
		int a = 20;
		Integer a1 = 40; // new Integer(40)
		
		
		System.out.println("Enter the numbers placed");
		Scanner s = new Scanner(System.in);
		
		int count = s.nextInt();
		
		
		int arr[] = new int[count]; // arr[1]
		
		System.out.println("Enter the "+(count-1)+" numbers available in the bag pressing the Enter key");
		
		
		for(int i = 0; i < count-1; i++){
			int val = s.nextInt();
			arr[val-1] = 1;
		}
		
		
		for(int i = 0; i < count-1; i++){
			if(arr[i] == 0){
				System.out.println("Missing Number : "+(i+1));
			}
		}
		
		
		
	}

}
