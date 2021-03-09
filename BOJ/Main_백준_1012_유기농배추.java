import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1012_유기농배추 {
	private static int M, cnt;
	private static int N;
	private static int[][] map;
	private static boolean[][] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());// tc
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < TC; t++) {
			cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			M = Integer.parseInt(st.nextToken());// 가로
			N = Integer.parseInt(st.nextToken());// 세로
			map = new int[N][M];// 배추의 지도
			visited = new boolean[N][M];// 방문 지도
			int K = Integer.parseInt(st.nextToken());// 배추의 개수

			// 배추 입력
			for (int i = 0; i < K; i++) {
				StringTokenizer s = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(s.nextToken());
				int y = Integer.parseInt(s.nextToken());
				map[y][x] = 1;// 배추 체크

			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						cnt++;
						dfs(i, j);
					}
				}
			}

			sb.append(cnt).append("\n");

		}
		System.out.println(sb);

	}// end of main

	public static void dfs(int x, int y) {
		// 상하좌우
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int r = x + dx[i];
			int c = y + dy[i];
			if (r >= 0 && c >= 0 && r < N && c < M) {
				if (map[r][c] == 1 && !visited[r][c]) {
					dfs(r, c);
				}

			}
		}

	}
}// end of class
