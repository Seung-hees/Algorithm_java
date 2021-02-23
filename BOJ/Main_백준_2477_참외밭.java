package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_2477_참외밭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max_x = 0;// x의 최고 길이
		int max_y = 0; // y의 최고의 길이
		int K = sc.nextInt();// 참외의 개수
		int[] arr = new int[6];// 방향 6개

		for (int i = 0; i < 6; i++) {
			int dir = sc.nextInt();
			int len = sc.nextInt();
			// 동 서
			if (dir == 1 || dir == 2) {
				if (max_x < len)
					max_x = len;
			}

			// 남 북
			if (dir == 3 || dir == 4) {
				if (max_y < len)
					max_y = len;
			}

			arr[i] = len;
		}

		int sum = 0;
		for (int i = 1; i < 6; i++) {
			sum += arr[i - 1] * arr[i];
		}
		sum += arr[0] * arr[5];

		int u = max_x * max_y * 2;
		System.out.println((sum - u) * K);

	}// end of main
}// end of class
