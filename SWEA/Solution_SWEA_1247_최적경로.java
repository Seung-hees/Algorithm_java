package workshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_1247_최적경로 {

	static int n, sx, sy, ex, ey;
	static int[] numbers;
	static boolean[] isSelected;
	static int min_distance;
	static int arr[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());// tc
		for (int t = 1; t <= TC; t++) {

			n = Integer.parseInt(br.readLine());
			min_distance = Integer.MAX_VALUE;
			arr = new int[n][2];// [][0] : x좌표, [][1]: y좌표
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			sx = Integer.parseInt(st.nextToken()); // 회사 x
			sy = Integer.parseInt(st.nextToken());// 회사 y
			ex = Integer.parseInt(st.nextToken());// 집 x
			ey = Integer.parseInt(st.nextToken()); // 집 y
			
			for (int i = 0; i < n; i++) {
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());

			}
			isSelected = new boolean[n];
			numbers = new int[n];
			// 순열 생성

			permutation(0);
			System.out.println("#" + t + " " + min_distance);
		}
	}

	private static void permutation(int cnt) {
		if (cnt == n) {// n까지 다 되면 종료

			int r = 0;// 현재 선택 좌표
			int d = 0;// 거리
			int c = 0;// 이전 좌표

			for (int i = 0; i < n; i++) {
				if (i == 0) {
					r = numbers[i];
					d += Math.abs(sx - arr[r][0]) + Math.abs(sy - arr[r][1]);// x+y
				} else {
					c = numbers[i - 1];
					r = numbers[i];
					d += Math.abs(arr[c][0] - arr[r][0]) + Math.abs(arr[c][1] - arr[r][1]);// x+y
				}

				if (i == n - 1) {// 마지막 좌표는 한번 더 집과 계산
					r = numbers[i];
					d += Math.abs(arr[r][0] - ex) + Math.abs(arr[r][1] - ey);// x+y

				}

			}
			if (d < min_distance) {
				min_distance = d;
			}

			return;
		}

		for (int i = 0; i < n; i++) {
			if (isSelected[i])
				continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			permutation(cnt + 1);
			isSelected[i] = false;
		}

	}

}
