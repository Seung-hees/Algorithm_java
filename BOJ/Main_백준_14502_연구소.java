import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 완탐
// 지도에 2인 바이러스를 찾아 list에 저장해주고
// 바이러스를 짓기 위한 지도를 하나 더 생성
// 벽을 세우고
// 해당 지도에서의 안전구역 최댓값을 구함
public class Main_백준_14502_연구소 {
	static class point {
		int x, y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	private static int N;
	private static int M, max = Integer.MIN_VALUE;
	private static int[][] map;
	private static int[][] wallmap;
	private static ArrayList<point> virus;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		virus = new ArrayList<>();// 바이러스의 좌표
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virus.add(new point(i, j)); // 바이러스 삽입
				}
			}
		}
		// 입력완료
		wallmap = new int[N][M];// 벽을 지을 맵 복사
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				wallmap[i][j] = map[i][j];
			}
		}

		dfs(0);// dfs 로 벽을 지을 곳 탐색 후, 벽을 지음
		System.out.println(max);

	}// end of main

	private static void dfs(int cnt) {

		if (cnt == 3) {
			virusbfs();// 바이러스 확인
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (wallmap[i][j] == 0) {
					wallmap[i][j] = 1;
					dfs(cnt + 1);
					wallmap[i][j] = 0;
				}
			}
		}

	}

	private static void virusbfs() {
		// 상하좌우
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		int cnt = 0;

		// 세워진 맵 바이러스 
		int[][] checkmap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				checkmap[i][j] = wallmap[i][j];

			}
		}
		//-------완료

		Queue<point> q = new LinkedList<>();
		for (int i = 0; i < virus.size(); i++) {
			q.offer(new point(virus.get(i).x, virus.get(i).y));
		}

		while (!q.isEmpty()) {

			point p = q.poll();

			int x = p.x;
			int y = p.y;

			for (int i = 0; i < 4; i++) {
				int r = x + dx[i];
				int c = y + dy[i];

				if (r >= 0 && c >= 0 && r < N && c < M && checkmap[r][c] == 0) {
					q.offer(new point(r, c));
					checkmap[r][c] = 2;
				}

			}

		}
		
		//안전구역
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (checkmap[i][j] == 0)
					cnt++;
			}
		}

		max = Math.max(max, cnt);

	}

}// end of class
