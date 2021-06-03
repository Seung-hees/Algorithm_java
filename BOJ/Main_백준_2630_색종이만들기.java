import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2630_색종이만들기 {
	private static int white = 0;
	private static int blue = 0;
	private static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력 완료

		division(0, 0, N);

		System.out.println(white);
		System.out.println(blue);

	}// end of main

	private static void division(int r, int c, int n) {

		if (check(r, c, n)) {
			if (map[r][c] == 0) {
				white++;
			} else {
				blue++;
			}
			return;
		}

		int half = n / 2;

		// 4분할
		division(r, c, half);// 1사분면
		division(r, c + half, half);// 2사분면
		division(r + half, c, half);// 3사분면
		division(r + half, c + half, half);// 4사분면

	}

	private static boolean check(int r, int c, int n) {

		int color = map[r][c];

		for (int i = r; i < r+n; i++) {
			for (int j = c; j < c+n; j++) {
				if (map[i][j] != color) {
					return false;
				}
			}
		}

		return true;
	}

}// end of class
