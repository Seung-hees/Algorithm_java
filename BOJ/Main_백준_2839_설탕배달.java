package workshop;

import java.util.Scanner;

public class Main_백준_2839_설탕배달 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int result = 0; // 결과론적으로 가져가는 설탕봉지 수
		
		int N = sc.nextInt(); //입력 받는 수
		int min = Integer.MAX_VALUE;
		
		for (int x = 0; x <= 1000; x++) {//5
			for (int y = 0; y <= 1700; y++) {//3
				if(5*x + 3*y == N ) {
					int k = x+y;
					if(k<min) {
						min = k;
					}
				}
			}
		}
		
		if(min == Integer.MAX_VALUE) {
			min = -1;
		}
		
		System.out.println(min);
		
		
		
	}
}
