import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1953_탈주범검거 {

	static int[] dx = { -1, 1, 0, 0 };// 상하 좌우
	static int[] dy = { 0, 0, -1, 1 };

	static class point {
		int x;
		int y;
		int num;

		public point(int x, int y, int num) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
		}

	}

	private static int[][] map;
	private static boolean[][] visited;
	private static int N;
	private static int M;
	private static int L;
	private static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());// 세로 크기
			M = Integer.parseInt(st.nextToken());// 가로 크기

			int R = Integer.parseInt(st.nextToken());// 맨홀 뚜껑 세로 위치
			int C = Integer.parseInt(st.nextToken());// 맨홀 뚜껑 가로 위치

			L = Integer.parseInt(st.nextToken());// 탈출 후 소요된 시간 L

			cnt = 0; // 개수

			map = new int[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 입력완료

			bfs(R, C);

			System.out.println("#" + t + " " + cnt);
		}

	}// end of main

	private static void bfs(int r, int c) {

		Queue<point> q = new LinkedList<point>();
		q.offer(new point(r, c, map[r][c]));
		visited[r][c] = true;
		cnt++;
		int level = 1;

		while (level++ < L) {

			int size = q.size();

			while (size-- > 0) {

				point p = q.poll();
				int x = p.x;
				int y = p.y;
				int n = p.num;

				for (int d = 0; d < 4; d++) {// 0 : 상 ,1: 하 ,2: 좌, 3: 우
					// 상하
					if (n == 2 && (d == 2 || d == 3))
						continue;
					if (n == 3 && (d == 0 || d == 1))
						continue;
					if (n == 4 && (d == 1 || d == 2))
						continue;
					if (n == 5 && (d == 0 || d == 2))
						continue;
					if (n == 6 && (d == 0 || d == 3))
						continue;
					if (n == 7 && (d == 1 || d == 3))
						continue;

					int nx = x + dx[d];
					int ny = y + dy[d];

					if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && map[nx][ny] != 0) {
						// 이부분에서 체크 해야됨.(매칭)!
						// 상-> 하, 하 ->상 , 좌 -> 우, 우-> 좌
						if (check(dx[d], dy[d], map[nx][ny])) {
							q.offer(new point(nx, ny, map[nx][ny]));
							visited[nx][ny] = true;
							cnt++;

						}

					}

				}
			}

		}

	}

	private static boolean check(int i, int j, int val) {
		// 상하좌우
		if (i == -1 && j == 0) { // 상
			if (val == 1 || val == 2 || val == 5 || val == 6) {// 하
				return true;
			}

		} else if (i == 0 && j == 1) {// 우
			if (val == 1 || val == 3 || val == 6 || val == 7) {// 좌
				return true;
			}

		} else if (i == 1 && j == 0) {// 하
			if (val == 1 || val == 2 || val == 4 || val == 7) {// 상
				return true;
			}

		} else if (i == 0 && j == -1) {// 좌
			if (val == 1 || val == 3 || val == 4 || val == 5) {// 우
				return true;
			}

		}

		return false;
	}

}// end of class
