import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_백준_2210_숫자판점프 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	private static HashSet<String> set = new HashSet<String>();
	private static int[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[5][5];

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		// 입력 완료
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				String s = "";
				dfs(i, j, 0, s);
			}
		}

		System.out.println(set.size());

	}// end of main

	private static void dfs(int i, int j, int cnt, String str) {
		if (cnt == 6) {
			set.add(str);
			return;
		}

		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];

			if (x >= 0 && x < 5 && y >= 0 && y < 5) {
				dfs(x, y, cnt + 1, str + map[x][y]);
			}
		}

	}

}// end of class
