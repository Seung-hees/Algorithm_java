import java.util.Scanner;

public class Main_백준_2447_별찍기 {
	private static char[][] map;

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		map = new char[n][n];

		// 반드시 초기화를 시켜주어야 함.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = ' ';
			}
		}

		star(0, 0, n);
		// 값 출력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}// end of main

	public static void star(int x, int y, int n) {

		if (n == 1) {
			map[x][y] = '*';
			return;

		}
		n /= 3;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1 && j == 1) {
					continue;
				}
				//  0,0 에서 작은 0,0 으로 전달 (작아질수록 인덱스의 수는 늘어남)
				star(x + (i * n), y + (j * n), n);

			}
		}

	}

}// end of class
