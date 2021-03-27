import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_17472_다리만들기2 {

	static class point {
		int x, y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	private static int[] dy = { 0, 1, 0, -1 };
	private static int[] dx = { -1, 0, 1, 0 };
	private static int[][] map;
	private static int N;
	private static int M;
	private static int[][] graph;
	private static int cnt;
	private static int[] minEdge;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 입력완료

		// 섬 라벨
		cnt = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					bfs_land(i, j, cnt);
					cnt++;
				}
			}
		} // 섬 2~cnt-1 까지 임.

		graph = new int[cnt][cnt];// 섬 1은 버림. idx에 맞춰서 최댓값으로 채움
		for (int i = 2; i < cnt; i++) {
			Arrays.fill(graph[i], 1000);// grapht[i] 의 모든 열을 채워줌!
		}

		// 섬 별 최단 거리 찾기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > 1) {
					caldis(i, j);// 거리 찾기
				}
			}
		}
		System.out.println(prim_bridge());

	}// end of main

	private static int prim_bridge() {
		boolean[] visited = new boolean[cnt];
		minEdge = new int[cnt];

		// 섬 2를 제외하고 나머지 최댓값
		for (int i = 3; i < cnt; i++) {
			minEdge[i] = 1000;
		}
		int sum = 0;// 구해야 하는 최소값

		for (int n = 2; n < cnt; n++) {

			int min = 1000;
			int minVertex = 0;
			// 최소 비용 정점
			for (int i = 2; i < cnt; i++) {
				if (!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
			}

			if (min == 1000) {
				return -1;
			}

			sum += min;
			visited[minVertex] = true;

			for (int i = 2; i < cnt; i++) {
				if (!visited[i] && graph[minVertex][i] != 1000 && minEdge[i] > graph[minVertex][i]) {
					minEdge[i] = graph[minVertex][i];
				}
			}

		}

		return sum;

	}

	private static void caldis(int x, int y) {
		int cur = map[x][y]; // 현재 기준 섬

		for (int k = 0; k < 4; k++) {// 사방탐색
			int len = 1;
			while (true) {
				int r = x + dx[k] * len;
				int c = y + dy[k] * len;
				// 범위 체크
				if (r >= 0 && c >= 0 && r < N && c < M) {
					if (map[r][c] == 0) {// 0 일 경우 쭉 가기
						len++;
						continue;
					}

					else if (map[r][c] == cur) {// 자신 섬 일 경우 , 해당 방향 탐색 멈춤
						break;
					}

					else {// 다른 섬 만날 경우
						if (len <= 2) {// 길이 칸이 2미만일 경우 break
							break;
						} // 인접행렬 갱신
						graph[cur][map[r][c]] = Math.min(graph[cur][map[r][c]], len - 1);

						break;
					}

				} else {// 범위 내 존재 안할 경우
					break;
				}
			}

		}

	}

	// 섬 라벨
	private static void bfs_land(int i, int j, int cnt) {

		Queue<point> q = new LinkedList<>();
		q.offer(new point(i, j));
		map[i][j] = cnt;

		while (!q.isEmpty()) {

			point p = q.poll();
			int x = p.x;
			int y = p.y;

			for (int k = 0; k < 4; k++) {
				int r = x + dx[k];
				int c = y + dy[k];

				if (r >= 0 && c >= 0 && r < N && c < M && map[r][c] == 1) {
					map[r][c] = cnt;
					q.offer(new point(r, c));
				}

			}

		}

	}

}// end of class
