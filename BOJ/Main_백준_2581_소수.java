package holiday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2581_소수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		int min = Integer.MAX_VALUE;
		boolean check;

		for (int i = M; i <= N; i++) {// 전체 수
			check = true;
			if(i==1) {// 1은 소수가 아님
				check = false;
				continue;
			}
			for (int j = 2; j <= Math.sqrt(i); j++) {// 2부터~ 해당 수의 제곱근 까지
				if (i % j == 0) {// 나누어진다면 소수가 아님
					check = false;
					break;
				}
			}
			if (check) {
				// 나누어지지 않는다면
				sum += i;
				if (min > i)
					min = i;
			}


			
		}// 전체 수 for문 종료

		if (sum == 0) {
			min = -1;
			System.out.println(min);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}

	}// end of main

}// end of class
