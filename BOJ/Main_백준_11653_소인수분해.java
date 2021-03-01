package holiday;

import java.util.Scanner;

public class Main_백준_11653_소인수분해 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();// 입력
		
		while(N>1) {// 1보다 클 때만

			for (int i = 2; i <= N; i++) {
				if(N % i == 0) {
					System.out.println(i);
					N/=i;
					break;
				}
			}
			
		}//end of while
	
		
	}// end of main
}// end of class
