import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1010_다리놓기2 {
	// 선택이 되지 않고 , 되고 nCr = n-1Cr-1 + n-1Cr

	private static int N;
	private static int M;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			int[][] dp = new int[N + 1][M + 1];// mCn

			for (int j = 1; j < M + 1; j++) {
				dp[1][j] = j;
			}
			
			for (int i = 2; i < N+1; i++) {
				dp[i][1] = 0;
			}
			
			for (int n = 2; n < N+1; n++) {
				for (int m = 2; m < M+1; m++) {
					dp[n][m] = dp[n][m-1] +dp[n-1][m-1];
				}
			}

			System.out.println(dp[N][M]);

		} // end of tc

	}// end of main

}// end of class
