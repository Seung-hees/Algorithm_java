import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_4963_섬의개수 {
	static class point{
		int x;
		int y;
		
		point(int x, int y){
			this.x = x;
			this.y = y;
		}
		
	}

	private static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
	private static int[][] map;
	private static int cnt;
	private static int w;
	private static int h;

	// 1은 땅 , 0은 바다
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());// 너비
			h = Integer.parseInt(st.nextToken());// 높이

			if (w == 0 && h == 0) {
				break;
			}
			map = new int[h][w];
			visited = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력 완료
			cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						cnt++;// 1섬
						visited[i][j] = true;
						//dfs(i, j);
						bfs(new point(i,j));
					}
				}
			}

			System.out.println(cnt);

		}

	}// end of main

	private static void bfs(point p) {
		Queue<point> q = new LinkedList<>();
		q.offer(p);
		
		while(!q.isEmpty()) {
			
			point pp = q.poll();
			
			for (int i = 0; i < 8; i++) {
				int x = pp.x + dx[i];
				int y = pp.y + dy[i];

				if (x>=0 && y>=0 && x<h && y<w && map[x][y] == 1 && !visited[x][y])  {
					visited[x][y] = true;
					q.offer(new point(x,y));
				}

			}
		}
		
	}


	private static void dfs(int r, int c) {

		for (int i = 0; i < 8; i++) {
			int x = r + dx[i];
			int y = c + dy[i];

			if (x>=0 && y>=0 && x<h && y<w && map[x][y] == 1 && !visited[x][y])  {
				visited[x][y] = true;
				dfs(x, y);
			}

		}

	}

}// end of class
