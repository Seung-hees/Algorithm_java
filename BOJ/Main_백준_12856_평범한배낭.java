import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_12856_평범한배낭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());// 물품의 수
		int K = Integer.parseInt(st.nextToken());// 버틸수 있는 무게

		int[][] knapsack = new int[N + 1][K + 1];

		for (int i = 0; i < N + 1; i++) {
			knapsack[i][0] = 0;
		}

		for (int i = 0; i < K + 1; i++) {
			knapsack[0][i] = 0;
		}

		int[][] pro = new int[N + 1][2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int w = Integer.parseInt(st.nextToken()); // 물건의 무게
			int v = Integer.parseInt(st.nextToken());// 물건의 가치

			pro[i][0] = w;
			pro[i][1] = v;

		}

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < K + 1; j++) {
				if (pro[i][0] > j) {// wi>w
					knapsack[i][j] = knapsack[i - 1][j];
				} else {
					knapsack[i][j] = Math.max(pro[i][1] + knapsack[i - 1][j - pro[i][0]], knapsack[i - 1][j]);
				}

			}
		}

		System.out.println(knapsack[N][K]);
	}// end of main

}// end of class
