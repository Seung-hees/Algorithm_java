package bbbb;

//DP
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1520_내리막길 {

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	private static int[][] map;
	private static int M;
	private static int N;
	private static int[][] result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[M + 1][N + 1];// 외벽
		result = new int[M + 1][N + 1];

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				result[i][j] = -1;// 중복을 피하기 위해 (이미 탐색을 했는데 경로의 수가 0일 수도 있기 때문)
			}
		}

		System.out.println(dfs(1, 1));

	}// end of main

	private static int dfs(int i, int j) {

		result[i][j] = 0;

		for (int k = 0; k < 4; k++) {
			int r = i + dx[k];
			int c = j + dy[k];

			if (r >= 1 && c >= 1 && r <= M && c <= N) {

				if (map[r][c] < map[i][j]) {
					if (r == M && c == N) { // 끝점에 도달하면 경우의수 1추가
						result[i][j] += 1;
					}

					if (result[r][c] >= 0) {// 0 이상 이미 다녀온 경로라면!
						result[i][j] += result[r][c];
					} else {// 아니라면 탐색
						result[i][j] += dfs(r, c);
					}
				}
			}
		}
		return result[i][j];

	}

}// end of class
