import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 토마토 생성자
class tomato {
	int x;
	int y;

	tomato(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

public class Main_백준_7576_토마토 {

	private static int[][] visited;
	private static int[][] map;
	private static Queue<tomato> q;
	private static int M, N, cnt;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		q = new LinkedList<tomato>();// 토마토의 좌표 큐
		map = new int[N][M]; // 토마토 지도
		visited = new int[N][M];// 방문 배열
		cnt = 0;

		// tomato 입력
		for (int i = 0; i < N; i++) {
			StringTokenizer s = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(s.nextToken());
				if (map[i][j] == -1) {// -1이면 방문 하면 안됨
					visited[i][j] = -1;
				} else if (map[i][j] == 1) { // 1이라면 큐에 삽입
					q.offer(new tomato(i, j));
					visited[i][j] = 0;// 1일차
				}

			}
		}

		BFS();// 탐색 시작
		// 익지 않은 토마토가 존재 시 0 출력 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					cnt = -1;
					break;
				}
			}
		}
		System.out.println(cnt);

	}// end of main

	public static void BFS() {
		if (q.size() == N * M) {// 모두가 1, 이미 다 익어있는 상태
			return;
		}

		int[] dx = { -1, 0, 1, 0 };// 상우하좌
		int[] dy = { 0, 1, 0, -1 };

		while (!q.isEmpty()) {// 꺼내기
			tomato t = q.poll();
			int x = t.x;
			int y = t.y;
			map[x][y] = 1;// 익었다고 표시

			for (int i = 0; i < 4; i++) {
				// 새로운 좌표 값
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {// 범위초과 확인
					if (map[nx][ny] == 0 && visited[nx][ny] == 0) {// 토마토가 익지 않고 방문하지 않았다면
						q.offer(new tomato(nx, ny));// 큐에 넣어주기
						visited[nx][ny] = visited[x][y] + 1; // 몇 일차 값을 더해줌
						if (cnt < visited[nx][ny])// 최대 일수
							cnt = visited[nx][ny];
					}
				}
			} // end of for
		} // end of while

	}
}// end of class
