import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class point {

	int r;
	int c;

	point(int x, int y) {
		this.r = x;
		this.c = y;
	}

}

public class Main_백준_2178_미로탐색 {
	private static int[][] visited, miro;
	private static int N, M;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		miro = new int[N][M];// 미로
		visited = new int[N][M];// 방문 여부

		// 미로 입력
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				miro[i][j] = s.charAt(j) - '0';
			}
		}

		bfs(0, 0);// 1,1 칸에서 출발
		System.out.println(visited[N - 1][M - 1]);

	}// end of main

	public static void bfs(int x, int y) {
		int[] dx = { -1, 0, 1, 0 };// 행
		int[] dy = { 0, 1, 0, -1 };// 열
		Queue<point> q = new LinkedList<>();// 큐 생성
		q.offer(new point(x, y));// 처음
		visited[x][y] = 1;

		while (!q.isEmpty()) {
			int r = q.peek().r;
			int c = q.peek().c;
			if (r == N - 1 && c == M - 1) {// 종료칸에 도달 시
				return;// 종료
			}
			q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = r + dx[i];
				int nc = c + dy[i];
				// 조건
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && miro[nr][nc] == 1 && visited[nr][nc] == 0) {
					visited[nr][nc] = visited[r][c] + 1;// 이동 횟수
					q.offer(new point(nr, nc));// 새로운 값 삽입
				}
			}

		}

	}
}// end of class
