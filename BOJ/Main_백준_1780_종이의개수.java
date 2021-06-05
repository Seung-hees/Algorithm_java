import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//9개로 자르기
//-1,0,1 탐색
public class Main_백준_1780_종이의개수 {
	private static int[][] arr;
	private static int minusone = 0, zero = 0, one = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 입력완료

		division(0, 0, N);
		System.out.println(minusone);
		System.out.println(zero);
		System.out.println(one);

	}// end of main

	private static void division(int r, int c, int n) {

		if (!check(r, c, n)) {
			// 9분할
			int size = n / 3;

			division(r, c, size);
			division(r, c + size, size);
			division(r, c + 2 * size, size);

			division(r + size, c, size);
			division(r + size, c + size, size);
			division(r + size, c + 2 * size, size);

			division(r + 2 * size, c, size);
			division(r + 2 * size, c + size, size);
			division(r + 2 * size, c + 2 * size, size);

		} else {
			if (arr[r][c] == 0) {
				zero++;
			} else if (arr[r][c] == -1) {
				minusone++;
			} else {
				one++;
			}

		}

	}

	private static boolean check(int r, int c, int n) {
		int tmp = arr[r][c];
		for (int i = r; i < r + n; i++) {
			for (int j = c; j < c + n; j++) {
				if (tmp != arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}// end of class
