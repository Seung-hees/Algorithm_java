package hw;

import java.util.Scanner;

public class Main_백준_1978_소수_이승희 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int num = 0;// 개수
		boolean flag = true;

		for (int i = 0; i < tc; i++) {
			int s = sc.nextInt();
			if (s == 1)
				continue;
			
			for (int j = 2; j <=Math.sqrt(s) ; j++) {
				if (s % j == 0) {
					flag = false;//소수 아님
					break;
				}
			}

			if (flag) {
				num++;
			}
			flag = true;
		} // end of tc

		System.out.println(num);

	}// end of main

}// end of class
