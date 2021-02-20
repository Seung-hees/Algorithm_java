package holiday;

import java.util.Scanner;

public class Main_백준_13300_방배정 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 학생 수
		int K = sc.nextInt();// 최소한의 방의 수
		int[][] student = new int[7][2]; // 행 : 1~6학년 ,[0] 여자 [1] 남자
		for (int i = 0; i < N; i++) {
			int S = sc.nextInt();// 성별
			int Y = sc.nextInt();// 학년
			student[Y][S]++; // 학년,성별
		}
		int room = 0;

		for (int i = 1; i < 7; i++) {
			for (int j = 0; j < 2; j++) {
				room += student[i][j] / K;
				if (student[i][j] % K != 0)
					room++;
			}
		}
		System.out.println(room);

	}

}
