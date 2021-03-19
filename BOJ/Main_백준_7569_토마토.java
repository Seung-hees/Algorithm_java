import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_7569_토마토 {

	static class point {
		int x;
		int y;
		int z;

		public point(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}

	}

	private static Queue<point> q;
	private static int N, M, H;
	private static int[][][] tomato, visited;
	private static int level, cnt = 0, t = 0, u = 0;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		q = new LinkedList<>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		tomato = new int[N][M][H];// 토마토 입력
		visited = new int[N][M][H];

		// 입력받기 : 정수 1은 익은 토마토 , 0은 익지 않은 토마토, -1은 토마토가 들어있지 않은 칸
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < M; j++) {
				StringTokenizer s = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < N; k++) {

					tomato[k][j][i] = Integer.parseInt(s.nextToken());
					if (tomato[k][j][i] == -1) {
						visited[k][j][i] = -1;// 방문하면 안됨.
						u++;
					} else if (tomato[k][j][i] == 1) {// 1이면 방문 및 값 삽입
						q.offer(new point(k, j, i));
						visited[k][j][i] = 1;// 방문 표시
						t++;
					}

				}
			}

		}
		// 입력 성공

		bfs();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < N; k++) {
					if (visited[k][j][i] == 0) {
						cnt = -1;
						break;
					}

				}
			}
		}
		if (cnt == 0 || cnt == -1) {
			System.out.println(cnt);
		} else {
			System.out.println(cnt - 1);
		}

	}// end of main

	private static void bfs() {
		if (H * N * M == t + u)
			return;

		int[] dx = { -1, 0, 1, 0 };// 상우하좌
		int[] dy = { 0, 1, 0, -1 };
		int[] dz = { -1, 1 };// 하상

		while (!q.isEmpty()) {

			point p = q.poll();

			int x = p.x;
			int y = p.y;
			int z = p.z;

			// 상하좌우 확인
			for (int i = 0; i < 4; i++) {

				int rx = x + dx[i];
				int ry = y + dy[i];

				if (rx < N && ry < M && rx >= 0 && ry >= 0) {
					if (tomato[rx][ry][z] == 0 && visited[rx][ry][z] == 0) {
						q.offer(new point(rx, ry, z));
						visited[rx][ry][z] = visited[x][y][z] + 1;
						if (cnt < visited[rx][ry][z]) {
							cnt = visited[rx][ry][z];
						}
					}

				}

			}

			// 위아래 확인
			for (int i = 0; i < 2; i++) {
				int rz = z + dz[i];

				if (rz >= 0 && rz < H) {
					if (tomato[x][y][rz] == 0 && visited[x][y][rz] == 0) {
						q.offer(new point(x, y, rz));
						visited[x][y][rz] = visited[x][y][z] + 1;
						if (cnt < visited[x][y][rz]) {
							cnt = visited[x][y][rz];
						}
					}
				}

			}

		}

	}

}// end of class
