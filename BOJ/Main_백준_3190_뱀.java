import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// dfs 가 아니라 while 로 풀어야 하는 이유...????
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
	private static boolean[][][] visited;
	private static int[][] board;
	private static int N;
	private static HashMap<Integer, String> move;
	private static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());// map
		board = new int[N + 1][N + 1];// 1~N까지
		visited = new boolean[N + 1][N + 1][4];

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

		visited[1][1][1] = true;
		dfs(new Snake(1, 1, 1, 1, 1), 0, 1);// 뱀 1,1 시작하고 길이 1, 0초, 방향 오른쪽

		System.out.println(answer);
	}// end of main

	private static void dfs(Snake snake, int time, int dir) {
		// 0. 게임 종료 (벽에 부딪히거나 자기자신의 몸과 부딪힌다면) 게임이 몇초에 끝나는 가?
		time++;
		// 1. 머리를 늘려 다음 칸에 위치 시킨다.
		int nx = snake.hx + dx[dir];
		int ny = snake.hy + dy[dir];

		int tx = snake.tx;
		int ty = snake.ty;
		int len = snake.len;

		if (check(new Snake(nx, ny, tx, ty, len))) {
			answer = time;
			return;
		}

		visited[nx][ny][dir] = true;

		// 2. 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
		if (board[nx][ny] == 1) {// 사과 먹기
			board[nx][ny] = 0;
			len++;
		} else { // 3. 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
			for (int i = 0; i < 4; i++) {
				if (visited[tx][ty][i]) {
					visited[tx][ty][i] = false;
					tx = tx + dx[i];
					ty = ty + dy[i];
					//System.out.println(i);
					break;
				}
			}
		}
		// 맨 마지막 보낼 때
		if (move.containsKey(time)) {// 몇초 존재할 때 ,방향바꾸기
			String s = move.get(time);
			if (s.equals("L")) {// 왼쪽으로 90도
				dir = (dir + 3) % 4;
				//System.out.println("L");
			} else {// 오른쪽으로 90도
				dir = (dir + 1) % 4;
				//System.out.println("R");
			}
		}
		// 오른쪽 계산하기
		dfs(new Snake(nx, ny, tx, ty, len), time, dir);

	}

	private static boolean check(Snake snake) {

		int x = snake.hx;
		int y = snake.hy;
		// 벽에 부딪힘
		if (x <= 0 || y <= 0 || x > N || y > N) {
			//System.out.println("벽");
			return true;
		}
		
		// 자기 자신과 부딪힘
		for (int i = 0; i < 4; i++) {
			if (visited[x][y][i]) {
				//System.out.println("자기자신");
				return true;
			}
		}
		
		return false;

	}

}// end of class
