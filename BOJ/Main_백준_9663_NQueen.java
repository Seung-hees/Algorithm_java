import java.util.Scanner;

public class Main_백준_9663_NQueen {
	private static int N, result = 0;
	private static int[][] ches;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		ches = new int[N][N];

		dfs(0);

		System.out.println(result);
	}// end of main

	private static void dfs(int x) {

		if (x == N) {
			result++;
			return;
		}

		for (int i = 0; i < N; i++) {

			// 행과 열과 check
			if (check(x, i)) {
				ches[x][i] = 1;
				dfs(x + 1);
				ches[x][i] = 0;
			}

		}

	}

	private static boolean check(int x, int y) {

		if (ches[x][y] == 1)
			return false;
		// 행 검사

		for (int i = 0; i < N; i++) {
			if (i == x)
				continue;
			if (ches[i][y] == 1) {
				return false;
			}
		}

		// 열 검사

		for (int j = 0; j < N; j++) {
			if (j == y)
				continue;
			if (ches[x][j] == 1) {
				return false;
			}
		}

		// 대각선 검사
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < ches.length; j++) {
				if (i + j == x + y && ches[i][j] == 1) {
					return false;
				}
				if (i - j == x - y && ches[i][j] == 1) {
					return false;
				}

			}
		}

		return true;
	}

}// end of class
