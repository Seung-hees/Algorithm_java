package holiday;

import java.util.Scanner;

public class Main_백준_4948_베르트랑공준 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = 0;
		boolean check = true;

		while (true) {
			int n = sc.nextInt();
			if (n == 0)// 0 입력 받을 시 종료
				break;
			for (int i = n + 1; i <= 2 * n; i++) {// n보다 크고 2n 보다 작거나 같은
				for (int j = 2; j <= Math.sqrt(i); j++) {// 소수 확인
					if (i % j == 0) {
						check = false;// 소수가 아님
						break;
					}

				}
				if (check) {// 소수일 경우 카운트
					num++;
				}
				check = true;// 초기화
			} // for 종료

			System.out.println(num);
			num = 0;// 초기화

		}// end of while

	}// end of main

}// end of class
