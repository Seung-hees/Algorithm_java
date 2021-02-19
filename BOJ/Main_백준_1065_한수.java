package holiday;

import java.util.Scanner;

public class Main_백준_1065_한수 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		System.out.println(func(N));// N은 1000개보다 작거나 같음.

	}

	private static int func(int n) {
		boolean flag = false;
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			// 백의자리수 전까지 일때
			if (i < 100) {
				sum += 1;
			} else {
				int s = i;
				int f1 = s % 10;// 일의자리수
				s = s / 10;// 그 다음 수
				int f2 = s % 10; // 십의자리수
				s = s / 10;// 그 다음 수
				int cha = f2-f1;// 두개의 차.
				while(s!=0) {
					int f3 = s%10;
					if(cha ==f3-f2) {
						flag= true;
						
					}else {
						flag = false;
					}
					f2 = f3;
					s = s/10;
				}
				if(flag)
					sum++;
			}

		}
		return sum;

	}

}
