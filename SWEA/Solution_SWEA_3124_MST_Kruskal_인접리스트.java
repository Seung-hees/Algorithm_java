
// Kruskal's algorithm(ver.인접리스트) 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_SWEA_3124_MST_Kruskal_인접리스트 {

	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		long weight;

		public Edge(int from, int to, long weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}

	}

	static void make() {
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}

	static int findset(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = findset(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = findset(a);
		int bRoot = findset(b);

		if (aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;
	}

	private static int[] parents;// 서로소 집합에서 각 정점의 부모 정보 저장
	private static int V;
	private static Edge[] edgeList;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());// 정점의 개수
			int E = Integer.parseInt(st.nextToken());// 간선의 개수

			parents = new int[V + 1];
			edgeList = new Edge[E];

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken()); // from
				int b = Integer.parseInt(st.nextToken()); // to
				int c = Integer.parseInt(st.nextToken()); // weight
				
				edgeList[i] = new Edge(a,b,c);

			}
			Arrays.sort(edgeList);
			
			make();
			long result = 0;
			int count = 0;// 선택한 간선 수
			
			for (Edge edge: edgeList) {
				if(union(edge.from, edge.to)) {
					result+=edge.weight;
					if(++count == V-1) break;
				}
				
			}

			 sb.append("#").append(t).append(" ").append(result).append("\n");

		} // end of tc
		System.out.println(sb.toString());
	}// end of main

}// end of class
