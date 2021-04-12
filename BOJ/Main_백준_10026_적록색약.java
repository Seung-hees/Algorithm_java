import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_10026_적록색약 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	private static char[][] map;
	private static int[][] visited;
	private static int N;
	private static int[][] patient;
	private static int cnt_v;
	private static int cnt_p;

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

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new int[N][N];
		patient = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		// 입력 성공

		cnt_v = 0;
		cnt_p = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == 0) {// 방문하지 않은 곳
					cnt_v++;
					bfs_v(i, j, map[i][j]);
				}
				
				if (patient[i][j] == 0) {//환자용
					cnt_p++;
					bfs_p(i, j, map[i][j]);
				}
			}
		}

		System.out.println(cnt_v + " " + cnt_p);

	}// end of main

	private static void bfs_p(int i, int j, char ch) {// 환자 용

		Queue<point> q = new LinkedList<>();
		patient[i][j] = cnt_p;
		q.offer(new point(i, j));

		while (!q.isEmpty()) {
			point p = q.poll();
			int x = p.x;
			int y = p.y;

			for (int k = 0; k < 4; k++) {
				int r = x + dx[k];
				int c = y + dy[k];

				if (r >= 0 && c >= 0 && r < N && c < N && patient[r][c] == 0) {
					if (ch == 'R' && map[r][c] == 'G') {
						patient[r][c] = cnt_p;
						q.offer(new point(r, c));
					}else if(ch == map[r][c]) {
						patient[r][c] = cnt_p;
						q.offer(new point(r, c));
					}if (ch == 'G' && map[r][c] == 'R') {
						patient[r][c] = cnt_p;
						q.offer(new point(r, c));
					}
				}

			}

		}

	}

	private static void bfs_v(int i, int j, char ch) {// 정상

		Queue<point> q = new LinkedList<>();
		visited[i][j] = cnt_v;
		q.offer(new point(i, j));

		while (!q.isEmpty()) {
			point p = q.poll();
			int x = p.x;
			int y = p.y;

			for (int k = 0; k < 4; k++) {
				int r = x + dx[k];
				int c = y + dy[k];

				if (r >= 0 && c >= 0 && r < N && c < N && visited[r][c] == 0 && map[r][c] == ch) {
					visited[r][c] = cnt_v;
					q.offer(new point(r, c));
				}

			}

		}

	}

}// end of class
