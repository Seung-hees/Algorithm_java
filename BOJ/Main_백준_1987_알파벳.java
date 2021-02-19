package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1987_알파벳 {
	static char[][] arr;
	// 탐색배열
	static int[] di = { -1, 0, 1, 0 };// 상우하좌
	static int[] dj = { 0, 1, 0, -1 };
	static int R, C, max;
	static boolean[] alpha;// 알파벳 확인

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());// 행
		C = Integer.parseInt(st.nextToken());// 열
		max = Integer.MIN_VALUE;
		arr = new char[R][C];// 가로 세로로 배열 생성
		alpha = new boolean[26];

		// 배열입력
		for (int i = 0; i < R; i++) {// 행
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = s.charAt(j);
			}
		}

		// 출발 0,0,길이 1
		// 탐색 함수
		go(0, 0, 1);
		System.out.println(max);

	}// end of main

	private static void go(int i, int j, int len) {//
		int abc = (int) arr[i][j] - 65;
		alpha[abc] = true;// 방문함.

		// 탐색(상우하좌)
		for (int k = 0; k < 4; k++) {
			int r = i + di[k];
			int c = j + dj[k];

			if (r >= 0 && c >= 0 && r < R && c < C) {// 범위초과 확인
				if (!alpha[(int) arr[r][c] - 65]) {// 해당 되는 값이 있지 않다면 go
					go(r, c, len + 1);
				}

			}
		}
		if (max < len) {
			max = len;
		}
		alpha[abc] = false;
		return;

	}// end of func
}// end of class
