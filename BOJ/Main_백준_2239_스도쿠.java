import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_2239_스도쿠 {

	private static int[][] sdoku;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 9 * 9 행렬

		sdoku = new int[9][9];
		for (int i = 0; i < 9; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				sdoku[i][j] = str.charAt(j) - '0';
			}
		}

		dfs(0, 0);

	}// end of main

	private static void dfs(int r, int c) {

		if (r == 9) {// 종료
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(sdoku[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		if (c == 9) {// 열 다 차면
			dfs(r + 1, 0);// 그 다음 행
			return;
		}

		// System.out.println(r+" "+c);
		if (sdoku[r][c] == 0) {// 값이 만약 0이라면
			for (int i = 1; i <= 9; i++) {// 해당 되는 곳에 1 ~9 중 어떤 거 넣을 건지
				if (check(r, c, i)) {// 그 숫자 넣어도 되는지
					sdoku[r][c] = i;// 넣어줌
					dfs(r, c + 1);// 다음 열로 보내줌
					sdoku[r][c] = 0;// 앞에서 연산이 되지 않으면(다음번 것들 check 할때 사용해야 하니까 ) 
				}
			}// 0이 있는데 넘겨 지지 못한다.
			return;
		} else {// 0이 아니면 넘김
			dfs(r, c + 1);
		}

	}

	private static boolean check(int r, int c, int n) {
		// 행 검사
		for (int i = 0; i < 9; i++) {
			if (sdoku[r][i] == n)
				return false;
		}

		// 열 검사
		for (int i = 0; i < 9; i++) {
			if (sdoku[i][c] == n)
				return false;
		}

		int rx = r / 3 * 3;
		int ry = c / 3 * 3;

		// 사각형 검사
		for (int i = rx; i < rx + 3; i++) {
			for (int j = ry; j < ry + 3; j++) {
				if (sdoku[i][j] == n)
					return false;
			}
		}
		return true;
	}

}// end of class
