import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main_백준_1753_최단경로_Dijkstra {
	static class Edge {
		int to;
		int weight;

		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

	}


	private static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		int V = Integer.parseInt(st.nextToken());// 정점의 개수
		int E = Integer.parseInt(st.nextToken());// 간선의 개수

		int K = Integer.parseInt(br.readLine());// 시작 정점의 번호

		//int[][] adjList = new int[V + 1][V + 1];// 인접 행렬
		ArrayList<ArrayList<Edge>> adjList = new ArrayList<ArrayList<Edge>>();
		
		for (int i = 0; i < V+1; i++) {
			adjList.add(new ArrayList<Edge>());
		}
		
		
		int[] distance = new int[V + 1];// 거리 행렬

		boolean[] visited = new boolean[V + 1];// 방문 행렬

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int u = Integer.parseInt(st.nextToken());// u에서
			int v = Integer.parseInt(st.nextToken());// v로 가는
			int w = Integer.parseInt(st.nextToken());// 가중치 w

			adjList.get(u).add(new Edge(v,w));

		}
		for (int i = 0; i < V+1; i++) {
			distance[i] = INF;
		}
		distance[K] = 0;// 시작 정점

		for (int i = 1; i < V + 1; i++) {
			int min = Integer.MAX_VALUE;
			int current = 0;// min의 최소비용에 해당하는 정점 번호
			// 처리하지 않은 정점 중에서 출발지에서 가장 가까운 (최소비용) 정점 선택
			for (int j = 0; j < V + 1; j++) {
				if (!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}

			}

			visited[current] = true;

			for (Edge edge : adjList.get(current)) {
				if (!visited[edge.to] && edge.weight != 0 && distance[edge.to] > min + edge.weight) {
					distance[edge.to] = min + edge.weight;
				}
			}

		}

		for (int i = 1; i < V + 1; i++) {
			if (distance[i] == INF) {
				sb.append("INF").append("\n");
			} else {
				sb.append(distance[i]).append("\n");

			}

		}
		
		System.out.println(sb.toString());

	}// end of main

}// end of class
