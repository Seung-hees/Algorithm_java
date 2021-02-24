package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_11399_ATM {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
	
		
		int total = 0;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j <= i; j++) {
				sum += arr[j];
			}
			total+=sum;
		}
		System.out.println(total);
	
	}//end of main
}// end of class
