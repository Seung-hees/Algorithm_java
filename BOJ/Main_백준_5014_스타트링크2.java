import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// dfs 시간초과
// bfs 도 다른 방향으로 보내는 방법이 가능
public class Main_백준_5014_스타트링크2 {

	private static boolean[] visited;
	private static int cnt = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int F = Integer.parseInt(st.nextToken());// 건물 총 층
		int S = Integer.parseInt(st.nextToken());// 강호가 지금 있는 층
		int G = Integer.parseInt(st.nextToken());// 스타트링크 위치
		int U = Integer.parseInt(st.nextToken());// U버튼 누르면 위로 U층 이동
		int D = Integer.parseInt(st.nextToken());// D버튼 누르면 아래로 D층 이동
		visited = new boolean[F + 1];// 같은 층 반복 하면

		if (bfs(F, S, G, U, D) == -1) {
			System.out.println("use the stairs");
		} else {
			System.out.println(cnt);
		}

	}// end of main

	private static int bfs(int floor, int start, int end, int up, int down) {

		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int cur = q.poll();
				if (cur == end) {
					return cnt;
				}

				if (cur + up <= floor && !visited[cur + up]) {

					visited[cur + up] = true;
					q.offer(cur + up);
				}

				if (cur - down > 0 && !visited[cur - down]) {

					visited[cur - down] = true;
					q.offer(cur - down);
				}
			}
			cnt++;

		}

		return -1;
	}

}// end of class
