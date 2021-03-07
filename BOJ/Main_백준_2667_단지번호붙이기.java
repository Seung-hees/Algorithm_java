import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_2667_단지번호붙이기 {
	private static int N;
	private static int[][] map;
	private static int[][] visited;
	private static int cnt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];// 지도
		visited = new int[N][N];// 단지 표시
		cnt = 0;// 단지 체크 수
// 지도 입력
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		// 방문하지 않고 아파트인곳 찾아 dfs
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && visited[i][j] == 0) {
					cnt++;
					DFS(i, j);
				}
			}
		}
		// 각 단지의 아파트의 수 저장
		int[] arr = new int[cnt+1];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(visited[i][j]!=0)
					arr[visited[i][j]]++;
			}
		}

		System.out.println(cnt);
		// 오름차순 정렬
		Arrays.sort(arr);
		for (int i = 1; i <cnt+1; i++) {
			System.out.println(arr[i]);
		}

	}// end of main

	public static void DFS(int x, int y) {
		int[] dx = { -1, 0, 1, 0 };// 상하좌우
		int[] dy = { 0, 1, 0, -1 };

		visited[x][y] = cnt;
		for (int k = 0; k < 4; k++) {
			int r = x + dx[k];
			int c = y + dy[k];
			if (r >= 0 && r < N && c >= 0 && c < N && visited[r][c] == 0 && map[r][c] == 1) {// 범위 체크
				DFS(r, c);
			}
		}
	}
}// end of class
