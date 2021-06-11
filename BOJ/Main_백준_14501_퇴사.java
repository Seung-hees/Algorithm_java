import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// dp[N]: N일까지 얻는 이익
// dp [i] = Max(arr[i][1] + dp[j],dp[i]) // i : 기준일, j : (1 ~ i-1) 일

public class Main_백준_14501_퇴사 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N + 1][2];
		int[] dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());

			dp[i] = arr[i][1];

		}
		// 입력 완료

		for (int i = 2; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				if (i - j >= arr[j][0]) {// 현재 날 >= 확인하는 날 + 값
					dp[i] = Math.max(dp[j] + arr[i][1], dp[i]);
				}
			}
		}

		int max = 0;

		for (int i = 1; i <= N; i++) {
			if (i + arr[i][0] <= N + 1) {//그 다음날 까지 가능 , (예를들어 dp 마지막 날만 엄청 크다던)안 더해진 애들 도 있으므로 확인해야 함
				if (max < dp[i]) {
					max = dp[i];
				}
			}
		}

		System.out.println(max);

	}// end of main

}// end of class
