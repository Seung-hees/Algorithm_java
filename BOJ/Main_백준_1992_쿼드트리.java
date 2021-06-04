import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_1992_쿼드트리 {
	private static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		// 입력 완료
		division(0, 0, N);

	}// end of main

	private static void division(int r, int c, int n) {

		if (!check(r, c, n)) {

			int size = n / 2;
			System.out.print("(");
			division(r, c, size);// 왼쪽위
			division(r, c + size, size);// 오른쪽 위
			division(r + size, c, size);// 왼쪽 아래
			division(r + size, c + size, size);// 오른쪽 아래
			System.out.print(")");

		} else {
			System.out.print(map[r][c]);
		}

	}

	private static boolean check(int r, int c, int n) {

		int tmp = map[r][c];

		for (int i = r; i < r+n; i++) {
			for (int j = c; j < c+n; j++) {
				if (tmp != map[i][j]) {
					return false;
				}

			}
		}
		return true;
	}

}// end of class
