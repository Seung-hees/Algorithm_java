import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
//벽을 최소 몇 개 부수어야 하는 가? -> bfs
// 0을 우선적으로 지나가야함 => 우선순위 큐를 사용함
// visited 방문배열을 넣을 때 말고 빼낼 때 사용! (왜냐하면 0인 값에서 우선적으로 처리를 해주어야하기 때문)
public class Main_백준_1261_알고스팟 {
	static class Point implements Comparable<Point> {//0,1 순으로 정렬하여 우선순위 큐에 세팅!
		int r, c, broke;

		public Point(int r, int c, int broke) {
			super();
			this.r = r;
			this.c = c;
			this.broke = broke;// 벽
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", broke=" + broke + "]";
		}

		@Override
		public int compareTo(Point o) {// 정렬
			return Integer.compare(this.broke, o.broke);
		}
	}
	
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int C, R;
	static char[][] map;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우 탐색

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		tokens = new StringTokenizer(input.readLine(), " ");
		C = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		map = new char[R][];
		for (int r = 0; r < R; r++) {
			map[r] = input.readLine().toCharArray();
		}

		// 입력 완료
		System.out.println(bfs());
	}

	static int bfs() {
		boolean[][] visited = new boolean[R][C];
		PriorityQueue<Point> pq = new PriorityQueue<>();// 우선순위 큐
		pq.offer(new Point(0, 0, 0));

		while (!pq.isEmpty()) {
			// 1. 한녀석 빼기
			Point head = pq.poll();
			// 2. 사용하기
			if (visited[head.r][head.c]) {
				continue;
			}
			visited[head.r][head.c] = true;

			if (head.r == R - 1 && head.c == C - 1) {
				return head.broke;
			}
			// 3. 자식 찾기.
			for (int d = 0; d < deltas.length; d++) {
				int nr = head.r + deltas[d][0];
				int nc = head.c + deltas[d][1];

				if (isIn(nr, nc) && !visited[nr][nc]) {
					// 값을 넣어줌.
					if (map[nr][nc] == '1') {//1인 경우 벽 부수기 +1
						pq.offer(new Point(nr, nc, head.broke + 1));
					} else {// 0인 경우 단순 삽입
						pq.offer(new Point(nr, nc, head.broke));
					}
				}
			}
		}

		return -1;
	}

	static boolean isIn(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}

	
}