import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Main_백준_15683_감시 {

	static class point {
		int x;
		int y;
		int dir;

		public point(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}

	}

	private static int[][] map;
	private static ArrayList<point> cctv;
	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };
	private static int N, M, min = Integer.MAX_VALUE;
	private static int[][][] cctvDir = { // 상 0 , 우1, 하2, 좌3
			{}, // 0번 cctv
			{ { 0 }, { 1 }, { 2 }, { 3 } }, // 1번 cctv
			{ { 0, 2 }, { 1, 3 } }, // 2번
			{ { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } }, // 3번
			{ { 0, 1, 2 }, { 1, 2, 3 }, { 2, 3, 0 }, { 3, 0, 1 } }, // 4번
			{ { 0, 1, 2, 3 } },// 5번

	};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		cctv = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력 완료

		// 0 은 빈칸 6은 벽 1~5까지는 cctv
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && map[i][j] != 6) {
					cctv.add(new point(i, j, map[i][j]));
				}
			}
		}

		dfs(0);
		System.out.println(min);
	}// end of main

	private static void dfs(int idx) {
		if (idx == cctv.size()) {
			//System.out.println(1);
			checkzero();
			return;// 종료
		}

		int type = cctv.get(idx).dir;// 타입 r,c
		int x = cctv.get(idx).x;
		int y = cctv.get(idx).y;
		
		for (int i = 0; i < cctvDir[type].length; i++) {
			set(x, y, cctvDir[type][i], 1);
			dfs(idx + 1);
			set(x, y, cctvDir[type][i], -1);// 원복
		}

	}

	private static void set(int r, int c, int[] dir, int val) {
		for (int i = 0; i < dir.length; i++) {
			int tr = dx[dir[i]];
			int tc = dy[dir[i]];

			int nr = r + tr;
			int nc = c + tc;

			while (0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] != 6) {// 배열 범위 체크, 벽체크
				map[nr][nc] += val;
				nr += tr;
				nc += tc;
			}

		}
		
	}

	private static void checkzero() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					cnt++;
				}
			}
		}
		min = Math.min(cnt, min);
	}// end of chk
}// end of class
