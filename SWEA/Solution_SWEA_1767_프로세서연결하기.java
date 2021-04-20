import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 최대한 많은 core를 전원에 연결하였을 경우, 전선 길이의 합을 구하고자 한다.
// 여러방법이 있을 경우, 전선 길이의 합이 최소가 되는 값을 구하라.

/// core 의 개수 카운트 , 전선의 개수 count
public class Solution_SWEA_1767_프로세서연결하기 {

	static class point {
		int x;
		int y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };
	private static int[][] map;
	private static int N, minline;
	private static ArrayList<point> pr;
	private static int maxcore;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			maxcore = Integer.MIN_VALUE;
			minline = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

				}
			}
			// 입력완료

			pr = new ArrayList<point>();

			for (int i = 1; i < N - 1; i++) {// 테두리는 안함
				for (int j = 1; j < N - 1; j++) {
					if (map[i][j] == 1) {// 프로세서를 찾을 경우
						pr.add(new point(i, j));

					}
				}
			}
			// 맵을 만듦

			dfs(0, 0, 0);
			sb.append("#").append(t).append(" ").append(minline).append("\n");

		} // end of tc
		System.out.println(sb.toString());

	}// end of main

	private static void dfs(int idx, int core, int len) {
		if (idx == pr.size()) {
			if (maxcore < core) {
				maxcore = core;
				minline = len;
			} else if (maxcore == core) {
				if (minline > len)
					minline = len;
			}

			return;
		}

		int x = pr.get(idx).x;
		int y = pr.get(idx).y;

		for (int k = 0; k < 4; k++) {
			int cnt = 0;
			int nx, ny;
			int r = nx = x;
			int c = ny = y;

			while (true) {
				nx += dx[k];
				ny += dy[k];

				if (check(nx, ny))
					break;
				if (map[nx][ny] == 1) {// 전선이나 코어 만나면
					cnt = 0;
					break;
				}
				cnt++;

			}

			// 전선 채우기
			for (int i = 0; i < cnt; i++) {
				r += dx[k];
				c += dy[k];

				map[r][c] = 1;
			}
			// 전선 채워주지 않음
			if (cnt == 0) {
				dfs(idx + 1, core, len);
			}else {
				// 전선 연결, core 증가 , 전선의 길이 증가
				dfs(idx + 1, core + 1, len + cnt);
				// 다시 원상 복구

				r = x;
				c = y;
				for (int i = 0; i < cnt; i++) {
					r += dx[k];
					c += dy[k];

					map[r][c] = 0;
				}
				
			}

		}
	}

	private static boolean check(int r, int c) {
		return r < 0 || r >= N || c < 0 || c >= N;

	}

}// end of class
