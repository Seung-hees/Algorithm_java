
// Prim's algorithm (ver.인접리스트 )
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_SWEA_3124_MST_Prim_인접리스트 {

	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int V = Integer.parseInt(st.nextToken());// 정점의 개수
			int E = Integer.parseInt(st.nextToken());// 간선의 개수

			ArrayList<ArrayList<Edge>> adjList = new ArrayList<>();
			boolean[] visited = new boolean[V + 1];
			long[] minEdge = new long[V + 1];

			for (int i = 0; i <= V; i++) {
				minEdge[i] = Long.MAX_VALUE;
				adjList.add(new ArrayList<Edge>());
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());// a번 정점
				int b = Integer.parseInt(st.nextToken());// b번 정점
				int c = Integer.parseInt(st.nextToken());// c 가중치

				adjList.get(a).add(new Edge(a, b, c));
				adjList.get(b).add(new Edge(b, a, c));

			}
			// 입력 완료
			long result = 0;
			minEdge[1] = 0;// 임의의 정점 1번

			PriorityQueue<Vertex> q = new PriorityQueue<Vertex>();
			q.offer(new Vertex(1, minEdge[1]));
			int cnt = 0;// 정점의 개수

			while (!q.isEmpty()) {
				Vertex minVertex = q.poll();
				if (visited[minVertex.no])
					continue;

				result += minVertex.cost;
				visited[minVertex.no] = true;
				if (++cnt == V)
					break;

				for (Edge edge : adjList.get(minVertex.no)) {
					if (!visited[edge.to] && edge.weight != 0 && minEdge[edge.to] > edge.weight) {
						minEdge[edge.to] = edge.weight;
						q.offer(new Vertex(edge.to, minEdge[edge.to]));
					}
				}

			}

			sb.append("#").append(t).append(" ").append(result).append("\n");

		} // end of tc
		System.out.println(sb.toString());
	}// end of main

	static class Vertex implements Comparable<Vertex> {
		int no;
		long cost;

		public Vertex(int no, long cost) {
			super();
			this.no = no;
			this.cost = cost;
		}

		@Override
		public int compareTo(Vertex o) {
			return Long.compare(this.cost, o.cost);
		}

	}

}// end of class
