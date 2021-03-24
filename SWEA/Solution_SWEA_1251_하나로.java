import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_1251_하나로 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][2];

			boolean[] visited = new boolean[N];// 해당 정점 방문했는 지 확인 (A,B,C,D)
			double[][] cost = new double[N][N];// 결과 저장 배열

			double[] mincost = new double[N];// 최소비용 저장 배열
			Arrays.fill(mincost, Long.MAX_VALUE);// 최대로 저장!
			mincost[0] = 0; // 초기 비용 

			for (int i = 0; i < 2; i++) {// x,y좌표
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			double E = Double.parseDouble(br.readLine()); // 환경부담금

			// 비용 그래프 생성
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j)
						continue;

					cost[i][j] = Math.pow(Math.abs(map[i][0] - map[j][0]), 2)
							+ Math.pow(Math.abs(map[i][1] - map[j][1]), 2);

				}
			}

			double result = 0;

			for (int i = 0; i < N; i++) {// 횟수
				double min = (double) Long.MAX_VALUE;
				int current = 0;// 최소비용에 해당하는 정점 번호

				// 처리하지 않은 정점 중에서 출발지에서 가장 가까운 (최소비용) 정점 선택
				for (int j = 0; j < N; j++) {
					if (!visited[j] && min > mincost[j]) {
						min = mincost[j];// 최소비용인
						current = j;// 인덱스
					}

				}

				visited[current] = true;// 방문함
				//System.out.println(min);
				result += min;

				for (int j = 0; j < N; j++) {
					if (!visited[j] && mincost[j] > cost[current][j]) {// from->to
						mincost[j] = cost[current][j];// 값을 바꿔줌.
					}
				}

			}

			sb.append("#").append(t).append(" ").append(Math.round(result*E)).append("\n");

		}
		System.out.println(sb);

	}// end of main

}// end of class
