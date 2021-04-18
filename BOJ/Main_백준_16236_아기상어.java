import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//아기상어
class shark {
	int x;
	int y;
	int dist;

	shark(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}

}

public class Main_백준_16236_아기상어 {
	private static int N;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, -1, 0, 1 };

	private static PriorityQueue<shark> q = new PriorityQueue<shark>(new Comparator<shark>() {

		@Override
		public int compare(shark o1, shark o2) {

			if (o1.dist == o2.dist) {
				if (o1.x == o2.x) {
					return o1.y - o2.y;
				}
				return o1.x - o2.x;
			}

			return o1.dist - o2.dist;
		}
	});

	private static int size;
	private static int eat;
	private static int move;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());// 공간의 크기
		map = new int[N][N];// 상어 map
		int bx = 0, by = 0;
		// map 입력
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					bx = i;
					by = j;// map 에서는 0으로
					map[i][j] = 0;
				}
			}
		}
		size = 2;// 상어의 크기
		eat = 0;// 먹은 개수
		move = 0;// 움직인 총 거리

		bfs(bx, by);
		System.out.println(move);

	}// end of main

	private static void bfs(int x, int y) {
		visited = new boolean[N][N];
		visited[x][y] = true;
		q.offer(new shark(x, y, 0));

		while (!q.isEmpty()) {
			shark s = q.poll();

			int rx = s.x;
			int ry = s.y;
			int d = s.dist;

			// 꺼낼 때 방문처리
			if (map[rx][ry] > 0 && map[rx][ry] < size) {// 먹이가 있고, 상어 보다 작음
				map[rx][ry] = 0; // 물고기 제거
				eat++;
				move += d;

				if (size == eat) {
					size++;
					eat = 0;
				}
				d = 0;// 지나갈 때 0일 수도 있으니까.
				q.clear();
				visited = new boolean[N][N];

			}

			for (int i = 0; i < 4; i++) {
				int r = rx + dx[i];
				int c = ry + dy[i];

				if (r >= 0 && r < N && c >= 0 && c < N && !visited[r][c] && map[r][c] <=size) {
					visited[r][c] = true;
					q.offer(new shark(r, c, d + 1));

				}

			}

		}

	}
}// end of class
