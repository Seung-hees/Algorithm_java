import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_8382_방향전환 {

	static class point {
		int x;
		int y;
		int d;// 방향 0 : 가로 , 1 : 세로
		int cnt; // 이동횟수

		public point(int x, int y, int d, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.cnt = cnt;
		}

	}

	private static int[][] dx = { { -1, 0 }, { 1, 0 } };// 가로이동
	private static int[][] dy = { { 0, -1 }, { 0, 1 } };// 세로이동
	private static boolean[][][] visited;
	private static Queue<point> q;
	private static int x1, y1, x2, y2, result;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());// 테케 개수
		for (int t = 1; t <= TC; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			result = 0;
			x1 = Integer.parseInt(st.nextToken()) + 100;
			y1 = Integer.parseInt(st.nextToken()) + 100;
			x2 = Integer.parseInt(st.nextToken()) + 100;
			y2 = Integer.parseInt(st.nextToken()) + 100;

			visited = new boolean[201][201][2];
			q = new LinkedList<point>();

			q.offer(new point(x1, y1, 0, 0));// 가로로 시작
			q.offer(new point(x1, y1, 1, 0));// 세로로 시작

			visited[x1][y1][0] = true;// 두 부분이 겹칠 수 있으므로
			visited[x1][y1][1] = true;
			bfs();

			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);

	}// end of main

	private static void bfs() {

		while (!q.isEmpty()) {
			point p = q.poll();

			int x = p.x;
			int y = p.y;
			int d = p.d;
			int cnt = p.cnt;

			// 기저조건
			if (x == x2 && y == y2) {
				result = cnt;
				return;
			}

			int nc = cnt + 1;

			if (d == 0) {// 이전이 가로방향
				for (int i = 0; i < 2; i++) {
					int r = x + dx[i][0];
					int c = y + dx[i][1];

					if (r >= 0 && c >= 0 && r <= 200 && c <= 200 && !visited[r][c][1]) {// 범위체크
						visited[r][c][1] = true;
						q.offer(new point(r, c, 1, nc));
					}

				}

			}

			if (d == 1) {// 이전이 세로방향

				for (int i = 0; i < 2; i++) {
					int r = x + dy[i][0];
					int c = y + dy[i][1];

					if (r >= 0 && c >= 0 && r <= 200 && c <= 200 && !visited[r][c][0]) {// 범위체크
						visited[r][c][0] = true;
						q.offer(new point(r, c, 0, nc));
					}

				}

			}

		}

	}

}// end of class
