import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_SWEA_1868_파핑파핑지뢰찾기 {

	static class point {
		int x;
		int y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	private static int N;
	private static char[][] map;
	private static boolean[][] visited;
	private static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };// 시계 방향 8방향
	private static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			// 입력 완료
			int level = 0;
			while (true) {

				boolean chk = true;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (!visited[i][j] && map[i][j] == '.' && check(i,j)) {
							chk = false;
							bfs(new point(i, j));
							level++;
						}
					}
				}

				if (chk) {
					break;
				}

			}// end of while

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]=='.') {
						level++;
					}
				}
			}
			System.out.println("#" + t + " " + level);

		}

	}// end of main

	private static void bfs(point pp) {

		Queue<point> q = new LinkedList<point>();
		q.offer(pp);
		visited[pp.x][pp.y] = true;

		while (!q.isEmpty()) {
			point p = q.poll();
			int x = p.x;
			int y = p.y;

			for (int k = 0; k < 8; k++) {
				int r = x + dx[k];
				int c = y + dy[k];

				if (r >= 0 && c >= 0 && r < N && c < N && map[r][c] == '.' && !visited[r][c]) {// 모든 조건을 만족하는 것들
					visited[r][c] = true;
					map[r][c] = '1';
					if (check(r, c)) {
						q.offer(new point(r, c));
					}

				}
			}

		}

	}

	private static boolean check(int r, int c) {
		for (int k = 0; k < 8; k++) {
			int x = r + dx[k];
			int y = c + dy[k];
			if (x >= 0 && y >= 0 && x < N && y < N) {
				if(map[x][y] == '*') {// 지뢰
					return false;					
				}
			}
		}
		return true;
	}

}// end of class
