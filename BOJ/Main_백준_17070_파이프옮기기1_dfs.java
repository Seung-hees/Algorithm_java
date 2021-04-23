import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_17070_파이프옮기기1_dfs {
	
	// 왜 bfs 는 시간초과인거지..?
	// BFS를 구현할 때 보통 Queue를 이용해서 구현한다. 
	//BFS는 원래 같은 정점을 한 번 방문해야하는 알고리즘인데 Queue를 이용하면 사실상 같은 정점을 여러 번 방문하고 visited 리스트를 따로 만들어서 방문 여부를 확인하면서 진행한다. 
	// 따라서 DFS에 비해 시간이 더 많이 소요된다.
	
	//완전탐색을 풀어야 할 경우 범위가 매우 작으면 DFS로 풀이하되 범위가 크다면 다이나믹 프로그래밍으로 풀어야 한다.

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
