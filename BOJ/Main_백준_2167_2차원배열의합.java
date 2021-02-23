package boj;

import java.util.Scanner;

public class Main_백준_2167_2차원배열의합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();// 행
		int M = sc.nextInt();// 열

		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int K = sc.nextInt();// 합을 구할 부분의 개수

		for (int t = 0; t < K; t++) {
			int sx = sc.nextInt()-1;
			int sy = sc.nextInt()-1;
			int ex = sc.nextInt()-1;
			int ey = sc.nextInt()-1;

			int sum = 0;
			for (int i = sx; i <=ex; i++) {
				for (int j = sy; j <= ey; j++) {
					sum+=arr[i][j];
				}
			}

			System.out.println(sum);

		}

	}// end of main
}// end of class
