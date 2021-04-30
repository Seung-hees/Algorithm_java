import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_백준_1922_네트워크연결_Prim {

	static class Edge implements Comparable<Edge> {

		int to;
		int weight;

		public Edge() {
		}

		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight ;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		boolean[] visited = new boolean[N + 1];
		int[] dist = new int[N + 1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		for (int i = 0; i < N + 1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		ArrayList<ArrayList<Edge>> list = new ArrayList<ArrayList<Edge>>();

		for (int i = 0; i < N+1; i++) {
			list.add(new ArrayList<Edge>());
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list.get(a).add(new Edge(b, c));
			list.get(b).add(new Edge(a, c));
		}

		dist[1] = 0;

		pq.add(new Edge(1, 0));
		int result = 0;

		while (!pq.isEmpty()) {

			Edge cur = pq.poll();
			
			
			if (!visited[cur.to]) {
				visited[cur.to] = true;
				result +=cur.weight;

				for (Edge edge : list.get(cur.to)) {

					if (!visited[edge.to] && dist[edge.to] >  edge.weight) {
						dist[edge.to] = edge.weight;
						pq.add(new Edge(edge.to, dist[edge.to]));
					}

				}

			}

		}
		
		System.out.println(result);
		

	}// end of main

}// end of class
