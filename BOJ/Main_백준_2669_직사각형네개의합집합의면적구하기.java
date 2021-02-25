package com.ssafy;

import java.util.Scanner;

public class Main_백준_2669_직사각형네개의합집합의면적구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[][] arr = new boolean[100][100];

		for (int t = 0; t < 4; t++) {

			int sx = sc.nextInt();
			int sy = sc.nextInt();
			int ex = sc.nextInt();
			int ey = sc.nextInt();

			for (int i = sx; i < ex; i++) {
				for (int j = sy; j < ey; j++) {
					arr[i][j] = true;
				}
			}

		}

		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (arr[i][j])
					cnt++;
			}
		}

		System.out.println(cnt);

	}
}
