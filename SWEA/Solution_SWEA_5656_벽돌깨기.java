import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Solution_SWEA_5656_벽돌깨기 {

	private static int W;
	private static int H;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	private static int N;
	private static int min;

	static class point {
		int x;
		int y;
		int val;

		public point(int x, int y, int val) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			min = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 구슬 깨는 횟수
			W = Integer.parseInt(st.nextToken()); // 가로
			H = Integer.parseInt(st.nextToken()); // 세로

			int[][] map = new int[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 입력성공

			process(0, map);

			if (min == Integer.MAX_VALUE) {
				System.out.println("#" + t + " " + 0);
			} else {
				System.out.println("#" + t + " " + min);

			}

		}

	}// end of main

	private static void process(int cnt, int[][] arr) {

		if (cnt == N) {// 남아있는 벽의 수 count
			int count = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (arr[i][j] != 0) {
						count++;
					}
				}
			}
			// System.out.println(count);
			min = Math.min(min, count);

			return;
		}

		for (int j = 0; j < W; j++) {
			for (int i = 0; i < H; i++) {
				if (arr[i][j] != 0) {
					int[][] nmap = copy(arr);
					crush(i, j, nmap);
					move(nmap);// 빈것들 재조정
					process(cnt + 1, nmap);// 구슬 다시 쏘기
					break;

				}
			}
		}

	}

	private static void move(int[][] arr) {
		for (int j = 0; j < W; j++) {// 빈칸 확인 열부터
			for (int i = H - 1; i >= 0; i--) {
				if (arr[i][j] == 0) {
					int k = i - 1;
					while (k >= 0) {
						if (arr[k][j] != 0) {
							arr[i][j] = arr[k][j];// 옮기기
							arr[k][j] = 0;
							break;
						}
						k--;
					}
					if (k == -1) {
						break;
					}

				}
			}

		}

	}

	private static void crush(int x, int y, int[][] broken) {

		Queue<point> q = new LinkedList<point>();
		q.offer(new point(x, y, broken[x][y]));
		broken[x][y] = 0;

		while (!q.isEmpty()) {
			point p = q.poll();
			for (int i = 0; i < 4; i++) {
				int r = p.x;
				int c = p.y;
				int num = p.val;
				for (int j = 1; j < num; j++) {
					int nx = r + dx[i] * j;
					int ny = c + dy[i] * j;
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && broken[nx][ny] != 0) {
						if (broken[nx][ny] > 1)
							q.offer(new point(nx, ny, broken[nx][ny]));
						broken[nx][ny] = 0;
					}
				}

			}
		}

	}

	// 맵 복사
	private static int[][] copy(int[][] arr) {
		int[][] narr = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				narr[i][j] = arr[i][j];
			}
		}
		return narr;
	}

}// end of class
