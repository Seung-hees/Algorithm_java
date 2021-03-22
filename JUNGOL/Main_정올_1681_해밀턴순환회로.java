import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//조합
public class Main_정올_1681_해밀턴순환회로 {

	private static int N, min = Integer.MAX_VALUE;
	private static int[][] map;
	private static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine().trim());

		// map 입력 받기
		map = new int[N][N];
		visited = new boolean[N];// 방문 여부

		// MAP 입력
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited[0] = true;
		com(1, 0, 0);// 횟수, 현재 인덱스, 거리

		System.out.println(min);

	}// end of main

	private static void com(int cnt, int cur, int dis) {

		if (min <= dis) return;

		if (cnt == N) {//다시 회사로 돌아오기 이전까지
			if (map[cur][0] != 0) {
				min = Math.min(min, map[cur][0] + dis);
				return;
			}
		}

		// 조합
		for (int i = 0; i < N; i++) {
			if (!visited[i] && map[cur][i] != 0) {
				visited[i] = true;
				com(cnt + 1, i, dis + map[cur][i]);
				visited[i] = false;

			}
		}

	}

}// end of class
