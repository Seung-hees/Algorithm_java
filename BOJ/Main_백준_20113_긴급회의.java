package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_20113_긴급회의 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();// 플레이어 수
		int[] arr = new int[N + 1]; // 기권 수 포함

		for (int i = 0; i < N; i++) {// 플레이어 수 만큼 반복
			int n = sc.nextInt();
			arr[n]++;// 해당되는 플레이어 체크
		}

		int max = 0;// 최대값
		int idx = 0;// 해당 되는 플레이어
		for (int i = 1; i < N + 1; i++) {
			if (max < arr[i]) {
				max = arr[i];
				idx = i;
			}
		}

		int check = 0; // 중복 확인
		for (int i = 1; i < N + 1; i++) {
			if (max == arr[i] && idx != i) {
				check++;
			}
		}

		if (max != 0 && check == 0)
			System.out.println(idx);
		else
			System.out.println("skipped");

	}
}
