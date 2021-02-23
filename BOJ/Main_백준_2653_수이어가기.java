package boj;

import java.util.Scanner;

public class Main_백준_2653_수이어가기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max = 0;
		int p = 0;

		for (int i = N; i >= N / 2; i--) {
			int n1 = N;
			int n2 = i;
			int cnt = 2;
			int c = 0;
			while (true) {
				int n3 = n1 - n2;
				if (n3 < 0) {
					break;
				}
				cnt++;
				n1 = n2;
				n2 = n3;
			}

			if (cnt > max) {
				max = cnt;
				p = i;
			}
		}

		System.out.println(max);
		int s1 = N;
		int s2 = p;
		System.out.print(s1 + " " + s2 + " ");
		while (true) {
			int s3 = s1 - s2;
			if (s3 < 0) {
				break;
			}
			System.out.print(s3 + " ");
			s1 = s2;
			s2 = s3;

		}

	}// end of main

}// end of class
