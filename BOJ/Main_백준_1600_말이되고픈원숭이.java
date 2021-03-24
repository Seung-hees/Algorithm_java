import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_1600_말이되고픈원숭이 {
	static class point {
		int x;
		int y;
		int cnt;

		public point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;// 말처럼 이동한 횟수
		}

	}

	private static int[][] map;
	private static boolean[][][] visited;
	private static int N, M, K, level = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M][K + 1];// K일 때까지 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력 성공

		bfs();// 0 ,0 ,0부터 시작
		System.out.println(level);

	}// end of main

	private static void bfs() {
		Queue<point> q = new LinkedList<>();
		// 상우하좌, 대각선 탐색
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		int[] kx = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int[] ky = { 1, 2, 2, 1, -1, -2, -2, -1 };

		q.offer(new point(0, 0, 0));

		for (int i = 0; i < K+1; i++) {//0,0은 k번 안에 이동 안해도 되기 때문에 다 true
			visited[0][0][i] = true;
		}

		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				point p = q.poll();
				int x = p.x;
				int y = p.y;
				int cnt = p.cnt;

				// 기저조건
				if (x == N - 1 && y == M - 1)
					return;

				for (int i = 0; i < 4; i++) {// 상하좌우 탐색
					int r = x + dx[i];
					int c = y + dy[i];

					if (r >= 0 && c >= 0 && r < N && c < M && !visited[r][c][cnt] && map[r][c] == 0) {
						visited[r][c][cnt] = true;
						q.offer(new point(r, c, cnt));

					}

				}
				if (cnt < K) {// 아예 여기서 확인 필요 , 밑에서 확인 시 범위초과

					for (int i = 0; i < 8; i++) {// 대각선 탐색
						int r = x + kx[i];
						int c = y + ky[i];
						int nc = cnt + 1;

						if (r >= 0 && c >= 0 && r < N && c < M && !visited[r][c][nc] && map[r][c] == 0) {
							visited[r][c][nc] = true;
							q.offer(new point(r, c, nc));

						}

					}
				}

			}
			level++;

		}
		level = -1;// 시작점에서 도착점까지 갈수 없는 경우
		return;

	}

}// end of class
