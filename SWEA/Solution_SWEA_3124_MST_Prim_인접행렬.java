
// Prim's algorithm (ver.인접행렬)=> 시간초과
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_SWEA_3124_MST_Prim_인접행렬 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int V = Integer.parseInt(st.nextToken());// 정점의 개수
			int E = Integer.parseInt(st.nextToken());// 간선의 개수

			long[][] adjList = new long[V + 1][V + 1];
			long[] minEdge = new long[V + 1];
			boolean[] visited = new boolean[V + 1];

			for (int i = 0; i <= V; i++) {
				minEdge[i] = Long.MAX_VALUE;
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken()); // from
				int b = Integer.parseInt(st.nextToken()); // to
				int c = Integer.parseInt(st.nextToken()); // weight

				adjList[a][b] = c;
				adjList[b][a] = c;

			}

			long result = 0;
			minEdge[1] = 0;

			for (int c = 1; c <= V; c++) {
				long min = Long.MAX_VALUE;
				int minVertex = 0;
				for (int i = 1; i <= V; i++) {
					if (!visited[i] && min > minEdge[i]) {
						min = minEdge[i];
						minVertex = i;
					}
				}

				result += min;
				visited[minVertex] = true;

				for (int i = 1; i <= V; i++) {
					if (!visited[i] && adjList[minVertex][i] != 0 && minEdge[i] > adjList[minVertex][i]) {
						minEdge[i] = adjList[minVertex][i];
					}
				}

			}

			sb.append("#").append(t).append(" ").append(result).append("\n");

		} // end of tc
		System.out.println(sb.toString());
	}// end of main

}// end of class
