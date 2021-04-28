import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 1 -> M1 -> M2 -> N
// 1 -> M2 -> M1 -> N
// 의 최단 거리 비교
public class Main_백준_1504_특정한최단경로 {

	static class Edge implements Comparable<Edge> {
		int to;
		int weight;

		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

	}

	private static ArrayList<ArrayList<Edge>> list;
	private static int N;
	private static int[] dist;
	private static boolean[] check;
	private static int INF = 200000000;// 오버플로우로 틀림.... 간선의 최대 개수 * 가중치의 최댓값으로 설정하자! (20000*1000)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());// 정점의 개수
		int E = Integer.parseInt(st.nextToken());// 간선의 개수

		list = new ArrayList<ArrayList<Edge>>();

		for (int i = 0; i < N + 1; i++) {
			list.add(new ArrayList<Edge>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list.get(from).add(new Edge(to, weight));
			list.get(to).add(new Edge(from, weight));

		}

		st = new StringTokenizer(br.readLine(), " ");
		int M1 = Integer.parseInt(st.nextToken());
		int M2 = Integer.parseInt(st.nextToken());

		dist = new int[N + 1];
		check = new boolean[N + 1];

		Arrays.fill(dist, INF);

		// 1번 경우
		int result1 = 0;
		result1 += dijkstra(1, M1);
		result1 += dijkstra(M1, M2);
		result1 += dijkstra(M2, N);

		// 2번 경우
		int result2 = 0;
		result2 += dijkstra(1, M2);
		result2 += dijkstra(M2, M1);
		result2 += dijkstra(M1, N);

		int ans = 0;
		if (result1 >= INF && result2 >= INF) {
			ans = -1;
		} else {
			ans = Math.min(result2, result1);
		}

		System.out.println(ans);

	}// end of main

	private static int dijkstra(int start, int end) {
		Arrays.fill(dist, INF);
		Arrays.fill(check, false);

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start, 0));

		dist[start] = 0;

		while (!pq.isEmpty()) {
			Edge curNode = pq.poll();
			int cur = curNode.to;

			if (!check[cur]) {
				check[cur] = true;

				for (Edge node : list.get(cur)) {
					if (!check[node.to] && dist[node.to] > dist[cur] + node.weight) {
						dist[node.to] = dist[cur] + node.weight;
						pq.add(new Edge(node.to, dist[node.to]));
					}
				}
			}
		}
		return dist[end];
	}
}// end of class
