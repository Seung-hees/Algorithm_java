import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1018_체스판다시칠하기 {
	private static char[][] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int min = 64;
		arr = new char[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j);
			}
		} // 입력완료

		for (int i = 0; i < N - 8 + 1; i++) {
			for (int j = 0; j < M - 8 + 1; j++) {
				min = Math.min(min, Bsearch(i, j));
				min = Math.min(min, Wsearch(i, j));
			}
		}

		System.out.println(min);
	}// end of main

	private static int Wsearch(int x, int y) {// 시작을 W로
		char ch = 'W';

		int cnt = 0;
		// W라고 생각할때
		for (int i = x; i < x + 8; i += 2) {
			for (int j = y; j < y + 8; j += 2) {
				if (ch != arr[i][j])
					cnt++;
			}
		}

		for (int i = x; i < x + 8; i += 2) {
			for (int j = y + 1; j < y + 8; j += 2) {
				if (arr[i][j] != 'B')
					cnt++;
			}
		}

		for (int i = x + 1; i < x + 8; i += 2) {
			for (int j = y + 1; j < y + 8; j += 2) {
				if (ch != arr[i][j])
					cnt++;
			}
		}

		for (int i = x + 1; i < x + 8; i += 2) {
			for (int j = y; j < y + 8; j += 2) {
				if (arr[i][j] != 'B')
					cnt++;
			}
		}

		// System.out.println(cnt);
		return cnt;

	}

	private static int Bsearch(int x, int y) {// 시작을 B로
		char ch = 'B';

		int cnt = 0;

		// B라고 생각할때
		for (int i = x; i < x + 8; i += 2) {
			for (int j = y; j < y + 8; j += 2) {
				if (ch != arr[i][j])
					cnt++;
			}
		}

		for (int i = x; i < x + 8; i += 2) {
			for (int j = y + 1; j < y + 8; j += 2) {
				if (arr[i][j] != 'W')
					cnt++;
			}
		}

		for (int i = x + 1; i < x + 8; i += 2) {
			for (int j = y + 1; j < y + 8; j += 2) {
				if (ch != arr[i][j])
					cnt++;
			}
		}

		for (int i = x + 1; i < x + 8; i += 2) {
			for (int j = y; j < y + 8; j += 2) {
				if (arr[i][j] != 'W')
					cnt++;
			}
		}

		return cnt;
	}

}// end of class
