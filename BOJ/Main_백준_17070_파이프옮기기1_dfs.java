import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_17070_파이프옮기기1_dfs {
	
	// 왜 bfs 는 시간초과인거지..?

	static int[] dx = { 0, 1, 1 };// 가로, 세로, 대각선 순
	static int[] dy = { 1, 0, 1 };// 가로, 세로, 대각선 순

	private static int[][] map;
	private static int N;
	private static int cnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력완료

		dfs(0, 1, 0);
		System.out.println(cnt);

	}// end of main

	private static void dfs(int x, int y, int dir) {

		if (x == N - 1 && y == N - 1) { // 도착시 break
			cnt++;
			return;
		}

		for (int i = 0; i < 3; i++) {

			if (dir == 0 && i == 1) {// 가로일 때 세로 배제
				continue;
			} else if (dir == 1 && i == 0) {// 세로 일때 가로 배제
				continue;
			}
			int r = x + dx[i];
			int c = y + dy[i];

			if (r<N && c<N && i == 2 && map[r][c] == 0 && map[r - 1][c] == 0 && map[r][c - 1] == 0) {// 대각선 일때
				dfs(r, c, i);
			}
			if (r<N && c<N && i == 0 && map[r][c] == 0) {
				dfs(r, c, i);
			}
			else if (r<N && c<N && i == 1 && map[r][c] == 0) {
				dfs(r, c, i);
			}

		}

	}

}// end of class
