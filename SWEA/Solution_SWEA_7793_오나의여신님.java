
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 큐에 삽입 하기 위한 생성자 생성 (x,y, 악마인지 여부)
// 악마를 모두 넣은 후 , 수연을 마지막에 넣기
// 큐에서 꺼낼 때 : 악마 - 수연과 . 을 만나면 악마로 바꾸어주고 큐 삽입, 수연 - D 만나면 level 반환 후 , 종료 , 아니라면 . 부분으로 이동 및 큐 삽입.
// level 출력

public class Solution_SWEA_7793_오나의여신님 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int T;
	static int R, C;
	static char[][] map;
	static Queue<Point> points;
	static int A;

	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };//탐색

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			R = Integer.parseInt(tokens.nextToken());
			C = Integer.parseInt(tokens.nextToken());

			points = new LinkedList<>();
			map = new char[R][];
			Point sPoint = null;
			
			for (int r = 0; r < R; r++) {
				map[r] = input.readLine().toCharArray();//아예 String 을 배열로 저장
				for (int c = 0; c < C; c++) {
					if (map[r][c] == '*') {//악마를 큐에 삽입
						points.offer(new Point(r, c, true));
					} else if (map[r][c] == 'S') {//수연
						sPoint = new Point(r, c, false);
					}
				}
			} // 지도 읽기
				// 수연이는 모든 악마가 다 들어간 다음에 동작
			points.offer(sPoint);
			// System.out.println(points);
			A = Integer.MAX_VALUE;
			bfs();
			// 여전히 A가 MAX_VALUE이면 여신을 못만난것.
			output.append("#").append(t).append(" ").append(A == Integer.MAX_VALUE ? "GAME OVER" : A).append("\n");
		}
		System.out.println(output);
	}

	// 수연, 악마 따로 동시에라고 생각하지 않고 함께 움직이는 큐에 같은 레벨이라고 생각하기!!, 대신 생성자로 악마인지 아닌지 구분해주기!
	static void bfs() {
		int turn = 1;//level
		while (!points.isEmpty()) {
			// 초마다 현재 queue 사용하기...
			int size = points.size();
			while (size-- > 0) {
				Point head = points.poll();

				// 자식 탐색 한다.
				for (int d = 0; d < deltas.length; d++) {
					int nr = head.r + deltas[d][0];
					int nc = head.c + deltas[d][1];

					if (isIn(nr, nc)) {
						// 지금 녀석이 악마라면.. 다음으로 이동은 .과 S
						if (head.isDevil) {
							if (map[nr][nc] == '.' || map[nr][nc] == 'S') {
								map[nr][nc] = '*'; // 방문처리
								points.offer(new Point(nr, nc, true));
							}
						}
						// 지금 녀석이 수연이라면.. . 또는 D (여신 - 만나면 종료)
						else {
							if (map[nr][nc] == 'D') {
								A = turn;//A에 level 저장
								return;
							} else if (map[nr][nc] == '.') {
								map[nr][nc] = 'S';
								points.offer(new Point(nr, nc, false));
							}
						}
					}
				}
			}
			turn++;
		}
	}

	static boolean isIn(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}

	static class Point {
		int r, c;
		boolean isDevil;//악마인지의 여부

		public Point(int r, int c, boolean isDevil) {
			super();
			this.r = r;
			this.c = c;
			this.isDevil = isDevil;
		}

		@Override
		public String toString() {
			return "[r=" + r + ", c=" + c + ", isDevil=" + isDevil + "]";
		}
	}

}