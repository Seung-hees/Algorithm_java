package workshop;

import java.io.*;
import java.util.*;

public class Main_백준_1063_색종이 {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[101][101];// 가로 , 세로 최대 101칸

		int N = sc.nextInt();// 색종이 장수
		int cnt = 1;
		for (int t = 0; t < N; t++) {// 색종이 수 만큼

			int r = sc.nextInt();// 시작점 x
			int c = sc.nextInt(); // 시작점 y
			int w = sc.nextInt();// 너비- 행
			int h = sc.nextInt();// 높이 - 열

			for (int i = r; i < r + w; i++) {
				for (int j = c; j < c + h; j++) {
					arr[i][j] = cnt;
				}
			}

			cnt++;

		}
		for (int i = 1; i < cnt; i++) {
			int result = 0;
			for (int r = 0; r < 101; r++) {
				for (int c = 0; c < 101; c++) {
					if (arr[r][c] == i) {
						result++;
					}

				}

			}
			System.out.println(result);

		}

	}
}
