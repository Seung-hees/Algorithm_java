import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_SWEA_1249_보급로 {
	private static int[][] arr;
	private static boolean[][] visited;
	private static PriorityQueue<point> pq;
	private static int N;

	static class point {
		int x;
		int y;
		int cost;

		public point(int x, int y, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			pq = new PriorityQueue<>(new Comparator<point>() {

				@Override
				public int compare(point o1, point o2) {
					return o1.cost - o2.cost;
				}
			});// 오름차순
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j) - '0';
				}
			}

			sb.append("#").append(t).append(" ").append(bfs(0, 0)).append("\n");
		}

		System.out.println(sb.toString());
	}// end of main

	private static int bfs(int i, int j) {
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		pq.offer(new point(i, j, 0));
		visited[i][j] = true;

		while (true) {
			point p = pq.poll();
			int x = p.x;
			int y = p.y;
			int cost = p.cost;
			visited[x][y] = true;

			if (x == N - 1 && y == N - 1) {
				return cost;
			}

			for (int k = 0; k < 4; k++) {
				int r = x + dx[k];
				int c = y + dy[k];

				if (r >= 0 && c >= 0 && r < N && c < N && !visited[r][c]) {
					int ncost = cost + arr[r][c];
					pq.offer(new point(r, c, ncost));
				}
			}

		}

	}

}// end of class
