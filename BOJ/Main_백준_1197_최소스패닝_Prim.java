import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_백준_1197_최소스패닝_Prim {

	static class Edge implements Comparable<Edge> {
		int to;
		long weight;

		public Edge(int to, long weight) {
			super();

			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}

	}

	public static void main(String[] args) throws IOException {
		// V: 정점, E: 간선
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken()); // 정점
		int E = Integer.parseInt(st.nextToken()); // 간선

		// 인접 리스트 만들기
		ArrayList<ArrayList<Edge>> list = new ArrayList<ArrayList<Edge>>();

		for (int i = 0; i < V + 1; i++) {
			list.add(new ArrayList<Edge>());
		}
		// 인접 리스트 생성
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list.get(from).add(new Edge(to, weight));
			list.get(to).add(new Edge(from, weight));
		}

		// prim 알고리즘

		boolean[] visited = new boolean[V + 1];// 정점

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(1, 0));// 1번 노드 출발
		long result = 0;
		int cnt = 0;

		while (!pq.isEmpty()) {

			Edge edge = pq.poll();
			if (visited[edge.to])
				continue;// 이미 확인했으면 통과

			visited[edge.to] = true;
			result += edge.weight;

			for (Edge next : list.get(edge.to)) {
				if (!visited[next.to]) {
					pq.add(next);
				}
			}
			
			if(++cnt == V) {
				break;// 모든 노드 방문시 스탑
			}

		}
		
		System.out.println(result);

	}// end of main

}// end of class
