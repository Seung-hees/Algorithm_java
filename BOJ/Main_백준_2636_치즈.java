import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_2636_치즈 {

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
	private static int M;
	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };
	private static int[][] cheese;
	private static boolean[][] visited;
	private static int cnt;
	private static int time;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int sum = 0;
		cheese = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
				if (cheese[i][j] == 1) {
					sum++;// 처음 치즈의 총 개수
				}
			}
		}
		// 치즈 있음 1, 없음 0
		// 입력 완료.
		time = 0;
		while (true) {

			bfs(0, 0);
			boolean flag = true;

			time++;
			cnt = 0;

			// 치즈가 다 사라졌는 지 확인
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (cheese[i][j] != 0) {
						flag = false;
						cnt++;
					}
				}
			}

			if (flag) {
				break;
			}

			visited = new boolean[N][M];
			sum = cnt;

		}

		System.out.println(time);
		System.out.println(sum);

	}// end of main

	private static void bfs(int i, int j) {
		Queue<point> q = new LinkedList<point>();

		q.offer(new point(i, j));
		visited[i][j] = true;

		while (!q.isEmpty()) {

			point p = q.poll();
			int x = p.x;
			int y = p.y;

			for (int k = 0; k < 4; k++) {
				int r = x + dx[k];
				int c = y + dy[k];

				if (r >= 0 && c >= 0 && r < N && c < M && !visited[r][c]) {

					if (cheese[r][c] == 0) {// 0일 때
						visited[r][c] = true;
						q.offer(new point(r, c));
					} else {// 1일때
						visited[r][c] = true;
						cheese[r][c] = 0;
					}

				}

			}

		} // end of while

	}

}// end of class
