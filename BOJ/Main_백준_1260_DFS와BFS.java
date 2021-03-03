import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_1260_DFS와BFS {
	private static boolean[] check;
	private static int[][] graph;
	private static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());// 정점의 개수 N
		int M = Integer.parseInt(st.nextToken());// 간선의 개수 M
		int V = Integer.parseInt(st.nextToken());// 탐색을 시작할 정점의 번호 V

		graph = new int[N + 1][N + 1];// 정점과 간선을 저장할 배열
		check = new boolean[N + 1];// 정점을 방문했는지 여부 배열

		for (int i = 0; i < M; i++) {// 간선의 개수 만큼 입력 받음.
			StringTokenizer s = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(s.nextToken());// 서로 연결되어 있는지 확인
			int b = Integer.parseInt(s.nextToken());
			// graph 저장
			graph[a][b] = 1;
			graph[b][a] = 1;

		}
		DFS(V);
		System.out.println();
		Arrays.fill(check, false);// 방문 초기화
		BFS(V);// bfs 탐색

	}// end of main

	public static void DFS(int s) {
		check[s] = true;// 방문 체크
		System.out.print(s + " ");
		for (int i = 1; i < N + 1; i++) {
			if (graph[s][i] == 1 && !check[i])
				DFS(i);
		}

	}

	public static void BFS(int s) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(s);// 처음을 삽입
		check[s] = true;// 방문
		while (!queue.isEmpty()) {
			int v = queue.poll();// 방문할 부모노드
			System.out.print(v + " ");
			// 부모노드의 자식노드들 방문
			for (int i = 1; i < N + 1; i++) {
				if (graph[v][i] == 1 && !check[i]) {
					queue.offer(i);// 연결된 자식노드들 삽입
					check[i] = true;// 삽입 후 방문확인
				}

			}
		}

	}

}// end of class
