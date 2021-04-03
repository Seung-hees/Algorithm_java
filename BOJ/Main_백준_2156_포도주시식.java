import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_2156_포도주시식 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N + 1];
		int[] dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// System.out.println(Arrays.toString(arr));

		dp[1] = arr[1];
		if (N > 1) {
			dp[2] = arr[1] + arr[2];
		}

		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
		}
		System.out.println(dp[N]);
		
		//재귀
		//System.out.println(recur(N));
		
		/*static int recur(int N) {
			
			if(dp[N] == null) {
				dp[N] = Math.max(Math.max(recur(N - 2), recur(N - 3) + arr[N - 1]) + arr[N], recur(N - 1));
			}
			
			return dp[N];
		}*/

	}// end of main

}// end of class
