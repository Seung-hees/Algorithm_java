import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingDeque;

public class Main_백준_2589_보물섬 {

	static int[] dx = { -1, 0, 1, 0 };// 상우하좌
	static int[] dy = { 0, 1, 0, -1 };
	private static int N;
	private static int M;
	private static char[][] map;

	static class point {
		int x;
		int y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int max = 0;

		map = new char[N][M];
		boolean[][] check = new boolean[N][M];// bfs 탐색했는지 확인하는 배열

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'L' && !check[i][j]) {// 육지이고 bfs 탐색 체크 안한 거!
					max = Math.max(max, bfs(i, j));
					check[i][j] = true;
					//System.out.println(bfs(i,j));

				}

			}

		}
		System.out.println(max);

	}// end of main

	private static int bfs(int i, int j) {
		int level = 0;
		Queue<point> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		visited[i][j] = true;

		q.offer(new point(i, j));

		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				point p = q.poll();
				int x = p.x;
				int y = p.y;

				for (int k = 0; k < 4; k++) {
					int r = x + dx[k];
					int c = y + dy[k];

					if (r >= 0 && c >= 0 && r < N && c < M && map[r][c] == 'L' && !visited[r][c]) {
						visited[r][c] = true;
						q.offer(new point(r, c));
					}

				}

			}
			level++;

		}
		return level-1;

	}

}// end of class
