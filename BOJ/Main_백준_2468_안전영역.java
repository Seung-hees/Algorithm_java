import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2468_안전영역 {

	private static int[][] map;
	private static boolean[][] visited;
	private static int ans;
	private static int N;
	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		StringTokenizer st = null;

		// int min = Integer.MAX_VALUE;
		 int max = Integer.MIN_VALUE;

		ans = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
//				if (min > map[i][j])
//					min = map[i][j];
				if (max < map[i][j])
					max = map[i][j];
			}
		}
		// 입력 완료

		for (int i = 0; i <= max; i++) {
			visited = new boolean[N][N];
			ans = Math.max(ans, check(i));
		}

		System.out.println(ans);

	}

	private static int check(int h) {

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] > h && !visited[i][j]) {
					cnt++;
					visited[i][j] = true;
					dfs(i, j, h);
				}
			}
		}

		return cnt;
	}// end of main

	private static void dfs(int i, int j, int h) {

		for (int k = 0; k < 4; k++) {
			int r = i + dx[k];
			int c = j + dy[k];
			if (r >= 0 && c >= 0 && r < N && c < N && !visited[r][c] && map[r][c] > h) {
				visited[r][c] = true;
				dfs(r, c, h);
			}
		}

	}

}// end of class
