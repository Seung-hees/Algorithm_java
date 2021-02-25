package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_14696_딱지놀이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();// 라운드 수
		for (int t = 0; t < TC; t++) {

			int[] A = new int[5]; // A의 1,2,3,4 배열 하지만 0은 안씀
			int[] B = new int[5]; // B의 1,2,3,4 배열 하지만 0은 안씀

			int a = sc.nextInt();// a의 카드 수
			for (int i = 0; i < a; i++) {// a만큼 카드 실행
				int num = sc.nextInt();
				A[num]++;
			}

			int b = sc.nextInt();// b의 카드 수
			for (int i = 0; i < b; i++) {// b만큼 카드 실행
				int num = sc.nextInt();
				B[num]++;
			}

			// System.out.println(Arrays.toString(A));
			// System.out.println(Arrays.toString(B));

			// 비교
			for (int i = 4; i >= 1; i--) {
				if (A[i] > B[i]) {
					System.out.println("A");
					break;
				} else if (A[i] < B[i]) {
					System.out.println("B");
					break;
				} else {
					if (i == 1) {
						System.out.println("D");
						break;
					}
					continue;
				}
			}

		}

	}// end of main
}// end of class
