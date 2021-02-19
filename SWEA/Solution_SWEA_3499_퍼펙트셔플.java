package workshop;

import java.util.Scanner;

public class Solution_SWEA_3499_퍼펙트셔플 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int t = 1; t <= TC; t++) {
			
			int n = sc.nextInt();
			int a; 
			int b;
			if(n % 2 != 0) {
				a = n/2 + 1;
				b = n/2;
			}
			else {
				a = n/2;
				b = n/2;
			}
			
			String[] arr = new String[a];
			String[] arr2 = new String[b];
			
			for(int i  = 0; i < a; i++) {
				arr[i] = sc.next();
			}
			for(int i = 0; i < b; i++) {
				arr2[i] = sc.next();
			}
			
			
			int i_arr = 0;
			int i_arr2 = 0;
			System.out.print("#"+t+" ");
			for (int k = 0; k < n; k++) {
				if(k % 2 ==0 || k==0) {
					System.out.print(arr[i_arr]+" ");
					i_arr++;
				}
				
				else if(k%2!=0){
					System.out.print(arr2[i_arr2]+" ");
					i_arr2++;
				}
				
			}
			System.out.println();
			
			
		}
		
	}//end of main
	

}//end of class
