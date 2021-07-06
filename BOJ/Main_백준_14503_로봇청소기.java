import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14503_로봇청소기 {
	private static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };// 북 : 0 , 동 : 1, 남 : 2 , 서 : 3
	private static boolean[][] visited;
	private static int cnt = 0;
	private static int[][] map;
	private static int N;
	private static int M;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());// 세로
		M = Integer.parseInt(st.nextToken());// 가로

		st = new StringTokenizer(br.readLine(), " ");
		// 로봇청소기가 있는
		int r = Integer.parseInt(st.nextToken());// x좌표
		int c = Integer.parseInt(st.nextToken());// y좌표
		int d = Integer.parseInt(st.nextToken());// 방향 , 북 : 0 , 동 : 1, 남 : 2 , 서 : 3
		// 1은 벽
		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 입력완료
		// dfs?

		dfs(r, c, d);
		System.out.println(cnt);

	}// end of main

	private static void dfs(int r, int c, int d) {
//1. 청소하기
		if (!visited[r][c] && map[r][c] == 0) {// 청소할 구역
			cnt++;
			visited[r][c] = true;
		}
		// 2. 왼쪽 부터 검사

		boolean flag = false;
		int origin = d;
		for (int i = 0; i < 4; i++) {
			int x = r + dir[(d + 3) % 4][0];
			int y = c + dir[(d + 3) % 4][1];

			if (x >= 0 && y >= 0 && x < N && y < M && !visited[x][y] && map[x][y] == 0) {
				dfs(x, y, (d + 3) % 4);
				flag = true;
				break;
			}
			d = (d + 3) % 4;

		}
		// 방향대로 한칸 후진
		if (!flag) {
			int x = r + dir[(origin + 2) % 4][0];
			int y = c + dir[(origin + 2) % 4][1];
			if (x >= 0 && y >= 0 && x < N && y < M && map[x][y] == 0)// 벽만 아니라면 후진
				dfs(x, y, origin);

		}
		return;

	}

}// end of class
