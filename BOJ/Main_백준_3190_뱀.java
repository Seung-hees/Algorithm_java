import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_백준_3190_뱀 {

	static class Snake {
		int hx;// 머리
		int hy;// 머리
		int tx;// 꼬리
		int ty;// 꼬리
		int len; // 길이

		public Snake(int hx, int hy, int tx, int ty, int len) {
			this.hx = hx;
			this.hy = hy;
			this.tx = tx;
			this.ty = ty;
			this.len = len;
		}
	}

	private static int[] dx = { -1, 0, 1, 0 };// 상우하좌
	private static int[] dy = { 0, 1, 0, -1 };// 상우하좌
	private static boolean[][] visited;
	private static int[][] board;
	private static int N;
	private static HashMap<Integer, String> move;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());// map
		board = new int[N + 1][N + 1];// 1~N까지
		visited = new boolean[N + 1][N + 1];

		int apple = Integer.parseInt(br.readLine());// 사과의 개수

		StringTokenizer st = null;
		for (int i = 0; i < apple; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x][y] = 1;// 사과 체크
		}

		move = new HashMap<>();// 몇 초뒤 이동
		int time = Integer.parseInt(br.readLine());

		for (int i = 0; i < time; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			move.put(Integer.parseInt(st.nextToken()), (String) st.nextElement());
		}

		visited[1][1] = true;
		dfs(new Snake(1, 1, 1, 1, 1), 0, 1);// 뱀 1,1 시작하고 길이 1, 0초, 방향 오른쪽

	}// end of main

	private static void dfs(Snake snake, int time, int dir) {

		if (move.containsKey(time)) {// 몇초 존재할 때 ,방향바꾸기

		}
		// 오른쪽 계산하기

	}

}// end of class