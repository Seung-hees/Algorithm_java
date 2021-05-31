import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 그래프 탐색
// 나 - 아버지 1촌
// 나 - 할아버지 2촌
// 나 - 아버지 형제 3촌
public class Main_백준_2644_촌수계산 {
	private static boolean[][] graph;
	private static int n, level = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());// 1~n
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());// 관계의 수

		graph = new boolean[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x][y] = graph[y][x] = true;
		}		
		
		System.out.println(bfs(a,b));
	}// end of main

	private static int bfs(int a, int b) {
		boolean[] visited = new boolean[n + 1];
		Queue<Integer> q = new LinkedList<Integer>();
		visited[a] = true;
		q.offer(a);

		while (!q.isEmpty()) {
			int size = q.size();
			while (size--> 0) {
				int t = q.poll();
				if(t == b) {
					return level;
				}
				for (int i = 1; i < n + 1; i++) {
					if (graph[t][i] && !visited[i]) {
						visited[i] = true;
						q.offer(i);
					}
				}

			}
			level++;
		}
		return -1;
	}

}// end of class
