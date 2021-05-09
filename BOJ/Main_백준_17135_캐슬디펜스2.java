import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_백준_17135_캐슬디펜스2 {

	private static int[][] map;
	private static int N;
	private static int M;
	private static int D;

	private static int max;
	private static int[][] nmap;
	private static int[][] copymap;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		max = 0;

		N = Integer.parseInt(st.nextToken());// 행
		M = Integer.parseInt(st.nextToken());// 열
		D = Integer.parseInt(st.nextToken());// 공격거리 제한

		map = new int[N + 1][M];// n번째 행은 성
		copymap = new int[N + 1][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				copymap[i][j] = map[i][j];
			}
		}
		// 입력완료

		ArrayList<Integer> archer = new ArrayList<>();
		// 궁수 3명 배치
		wall(0, 0, archer);
		System.out.println(max);

	}// end of main

	// map을 원래대로 변경.
	public static void init() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = copymap[i][j];
			}
		}
	}

	private static void wall(int start, int cnt, ArrayList<Integer> archer) {

		if (cnt == 3) {
			init();
			attack(archer, map);
			return;
		}

		for (int j = start; j < M; j++) {
			archer.add(j);
			wall(j + 1, cnt + 1, archer);
			archer.remove(archer.size() - 1);
		}

	}

	private static void attack(ArrayList<Integer> archer, int[][] arr) {
		int res = 0;
		boolean[][] visited = new boolean[N + 1][M];
		for (int n = 0; n < N; n++) {// 최대 n턴 까지

			for (int j = 0; j < archer.size(); j++) {// 궁수 찾기
				int tmp = archer.get(j);
				int min = Integer.MAX_VALUE; // 최소거리
				int mi = Integer.MAX_VALUE; // 최소 거리의 x좌표
				int mj = Integer.MAX_VALUE; // 최소 거리의 y좌표

				for (int r = 0; r < N; r++) {
					for (int c = 0; c < M; c++) {
						if (arr[r][c] == 1) {// 적이 있다.

							int dist = Math.abs(r - N) + Math.abs(tmp - c);
							if (D >= dist) {// D이하 일때
								if (min > dist) {// 최소거리
									min = dist;
									mi = r;
									mj = c;
								} else if (min == dist) {// 만약에 같다면 y좌표가 더 작은것
									if (mj > c) {
										mi = r;
										mj = c;
									}
								}
							}

						}

					}
				}

				if (mi != Integer.MAX_VALUE && mj != Integer.MAX_VALUE && min <= D) {
					visited[mi][mj] = true;
				}

			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j]) {
						arr[i][j] = 0;
						res++;
						visited[i][j] = false;
					}
				}
			}
// move 한 행 아래로
			for (int i = N - 1; i >= 1; i--) {
				for (int j = 0; j < M; j++) {
					arr[i][j] = arr[i - 1][j];
				}
			}

			for (int j = 0; j < M; j++) {
				arr[0][j] = 0;// 한줄 줄이기
			}
		}
		max = Math.max(max, res);

	}

}// end of class
