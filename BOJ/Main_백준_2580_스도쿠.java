import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2580_스도쿠 {
	private static int[][] sdoku;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		sdoku = new int[9][9];

		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				sdoku[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력 완료
		dfs(0, 0);

	}// end of main

	private static void dfs(int r, int c) {

		if (r == 9) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(sdoku[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
			
			System.exit(0);// 종료
		}

		if (c == 9) {
			dfs(r + 1, 0);
			return;
		}


		if(sdoku[r][c] == 0) {
			for (int i = 1; i <= 9; i++) {
				if(check(r,c,i)) {
					sdoku[r][c] = i;
					dfs(r, c + 1);		
				}
			}
			// 찾기 실패 ... 그렇다면 종료.
			sdoku[r][c] = 0;
			return;
		}
		
		dfs(r,c+1);
		

	}

	private static boolean check(int r, int c, int n) {
		
		for (int i = 0; i < 9; i++) {
			if(sdoku[r][i] == n) {
				return false;
			}
		}
		
		for (int i = 0; i < 9; i++) {
			if(sdoku[i][c] == n) {
				return false;
			}
		}

		int nr = r / 3 * 3;
		int nc = c / 3 * 3;

		for (int i = nr; i < nr + 3; i++) {
			for (int j = nc; j < nc + 3; j++) {
				if(sdoku[i][j] == n) {
					return false;
				}
			}
		}

		return true;
	}


}// end of class
