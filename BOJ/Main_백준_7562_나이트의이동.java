import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class vector {
	int x;
	int y;

	vector(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

public class Main_백준_7562_나이트의이동 {
	private static int sx, sy, N, ex, ey;
	private static int[][] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());// tc
		for (int i = 1; i <= TC; i++) {

			N = Integer.parseInt(br.readLine());// 체스판 길이

			visited = new int[N][N];// 방문확인체크배열

			// 현재칸과 도착점 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 현재칸
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());

			// 도착점
			st = new StringTokenizer(br.readLine());
			ex = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());

			bfs();
			System.out.println(visited[ex][ey] - 1);

		} // end of tc

	}// end of main

	public static void bfs() {
		Queue<vector> q = new LinkedList<vector>();
		// 현재칸 삽입
		q.offer(new vector(sx, sy));
		visited[sx][sy] = 1;
		// 방향
		int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };

		while (!q.isEmpty()) {
			int r = q.peek().x;
			int c = q.peek().y;
			if (r == ex && c == ey) {
				return;
			}
			q.poll();// 꺼내기
			for (int i = 0; i < 8; i++) {
				int x = r + dx[i];
				int y = c + dy[i];
				if (x >= 0 && y >= 0 && x < N && y < N && visited[x][y] == 0) {
					q.offer(new vector(x, y));
					visited[x][y] = visited[r][c] + 1;
				}
			}

		}

	}

}// end of class
