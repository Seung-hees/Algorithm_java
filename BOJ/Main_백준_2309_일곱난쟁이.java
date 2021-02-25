package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_2309_일곱난쟁이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[9];

		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}

		int sum = 0;
		for (int i = 0; i < 9; i++) {
			sum += arr[i];
		}

		int h = sum - 100;

		Arrays.sort(arr);
		int s = 0;
		int k = 0;
		c: for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				if ((arr[i] + arr[j]) == h) {
					s = i;
					k = j;
					break c;
				}
			}
		}

		for (int j = 0; j < 9; j++) {
			if (j == s || j == k) {
				continue;
			}
			System.out.println(arr[j]);
		}

	}
}
