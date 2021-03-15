import java.util.Scanner;

public class Main_백준_2447_별찍기 {
	private static char[][] map;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		map = new char[n][n];

		star(0, 0, n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}// end of main

	public static void star(int x, int y , int n) {

		if (n == 1) {
			map[x][y] = '*';
			return;

		}
		n/=3;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1 && j == 1) {
					continue;
				}
				star(x + (i * n), y + (j * n), n);

			}
		}

	}

}// end of class
