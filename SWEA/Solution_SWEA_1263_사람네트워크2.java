import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1263_사람네트워크2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());// 사람의 수
			
			int[][] map = new int[N][N];// 인적 네트워크
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (i!=j && map[i][j] == 0) {
						map[i][j] = 99999999;
					}
				}
			}
			
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					if (i == k)
						continue; 
					for (int j = 0; j < N; j++) {
						if (i == j || k == j)
							continue; 
						if (map[i][j] > map[i][k] + map[k][j]) {
							map[i][j] = map[i][k] + map[k][j];
						}
					}
				}
			}
			int min = Integer.MAX_VALUE;// 최솟값 찾기
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum+= map[i][j];
				}
				min = Math.min(min,sum);
			}
			
			
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);


	}// end of main

}// end of class
