package add;

import java.util.Scanner;

public class Main_백준_2231_분해합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean check = false;
		
		int news = 0;// 생성자가 되어 새롭게 만들어지는 수
		int s = 0;
		// 처음 start 1부터 시작
		for (int i = 1; i < N; i++) {
			s = i;
			news = i; 
			while (s != 0) {
				news += s % 10;
				s /= 10;
			}
			if (news == N) {
				System.out.println(i);
				check = true;
				break;
			}

		} // end of for
		if (!check) {
			System.out.println(0);
		}
	}// end of main
}// end of class
