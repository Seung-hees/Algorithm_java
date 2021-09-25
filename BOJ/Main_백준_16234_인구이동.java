import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_16234_인구이동 {
	// bfs

	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };
	private static int N, L, R, cnt, value;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[][] wall;
	private static Queue<Point> q = new LinkedList<Point>();

	static class Point {

		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		visited = new boolean[N][N];// 상우하좌
		wall = new int[N][N];// 국경선 표현용

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 더이상 인구이동 불가능 하다면 종료
		int answer = 0;

		while (true) {
			int block = 1;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						value = 0;
						bfs(i, j, block++);// 1단계 : 국경 열기
					}
				}
			}

			if (!move(block)) {
				break;
			}else {
				answer++;
			}// 2단계: 인구이동 시작
			
			reset();// 초기화

		}

		System.out.println(answer);

	}// end of main

	private static void reset() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = false;
			}
		}

	}

	private static boolean move(int block) {
		int val = 0;
		int cnt = 0;
		int people = 0;
		boolean chk = false;
		for (int x = 1; x < block; x++) {
			val = 0;
			cnt = 0;
			people = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (wall[i][j] == x) {
						val+= map[i][j];
						cnt++;
					}
				}
			}
			if(cnt == 1) {
				continue;
			}
			people = val / cnt;
			chk = true;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (wall[i][j] == x) {
						map[i][j] = people;
					}
				}
			}
		}
		return chk;

	}

	private static void bfs(int i, int j, int block) {
		visited[i][j] = true;
		wall[i][j] = block;
		q.offer(new Point(i, j));

		while (!q.isEmpty()) {
			Point p = q.poll();
			int x = p.x;
			int y = p.y;

			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {

					int val = Math.abs(map[nx][ny] - map[x][y]);

					if (L <= val && val <= R) {
						wall[nx][ny] = block;
						visited[nx][ny] = true;
						q.offer(new Point(nx, ny));
					}
				}

			}

		}

	}

}// end of class
