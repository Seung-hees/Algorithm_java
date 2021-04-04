import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_2206_벽부수고이동하기 {
	private static int N;
	private static int M;
	private static int[][] map;

	static class point {
		int x;
		int y;
		int broke;

		public point(int x, int y, int broke) {
			super();
			this.x = x;
			this.y = y;
			this.broke = broke;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		// 입력
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {

				map[i][j] = s.charAt(j) - '0';

			}
		}
		// 입력 완료

		System.out.println(bfs());

	}// end of main

	private static int bfs() {// 최단 거리 구하기
		Queue<point> q = new LinkedList<point>();
		boolean[][][] visited = new boolean[N][M][2];// 방문배열
		// 상하좌우 탐색
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		q.offer(new point(0, 0, 0));// 삽입
		visited[0][0][0] = true;// 방문
		int level = 1;

		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				point p = q.poll();
				int x = p.x;
				int y = p.y;
				int cnt = p.broke;

				if (x == N - 1 && y == M - 1) {
					return level;
				}

				for (int k = 0; k < 4; k++) {
					int r = x + dx[k];
					int c = y + dy[k];

					if (r >= 0 && c >= 0 && r < N && c < M) {
						if (map[r][c] == 0 && !visited[r][c][cnt]) {// 벽이 아닐 경우
							visited[r][c][cnt] = true;
							q.offer(new point(r, c, cnt));

						} else if (map[r][c] == 1 && cnt == 0  && !visited[r][c][cnt+1] ) {// 벽일 경우
							visited[r][c][cnt+1] = true;
							q.offer(new point(r, c, 1));

						}

					}

				}

			}
			level++;
		}

		return -1;
	}// end of bfs

}// end of class
