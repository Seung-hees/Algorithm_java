import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_11404_플로이드_Floyd {

	public static final int INF = 1000000000;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());// 도시의 개수
		int m = Integer.parseInt(br.readLine());// 버스의 개수

		int[][] adjMatrix = new int[n + 1][n + 1];
		
		 for(int i=1; i < n + 1; i++) {
	            for(int j=1; j < n + 1; j++) {
	                if(i == j) continue;
	                adjMatrix[i][j] = INF;
	            }
	        }

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()); // 시작 도시
			int b = Integer.parseInt(st.nextToken()); // 도착 도시
			int c = Integer.parseInt(st.nextToken());// 비용

			adjMatrix[a][b] = Math.min(adjMatrix[a][b], c);

		}

		for (int k = 1; k < n + 1; k++) { // 경유지
			for (int i = 1; i < n + 1; i++) { // 출발지
				if (i == k)
					continue;
				for (int j = 1; j < n + 1; j++) { // 도착지
					if (i == j || k == j)
						continue;
					if (adjMatrix[i][k]!=INF && adjMatrix[k][j] !=INF && adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j]) {
						adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
					}
				}
			}
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if(adjMatrix[i][j]>=INF) {
					System.out.print(0+ " ");
				}else {
					System.out.print(adjMatrix[i][j] + " ");					
				}
			}
			System.out.println();
		}

	}// end of main

}// end of class
