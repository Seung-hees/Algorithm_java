import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int i = 1; i <= TC; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());// 과자 봉지의 개수
			int M = Integer.parseInt(st.nextToken());// 무게 합 제한
			int[] input = new int[N];

			StringTokenizer s = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				input[j] = Integer.parseInt(s.nextToken());
			}
			int max = -1; // 가져갈 수 있는 최댓값.
			for (int k = 0; k < N; k++) {
				for (int m = k+1; m < N; m++) {
					int sum = input[k] + input[m];
					if (sum <= M) {
						if (max < sum) {
							max = sum;
						}
					}
				}
			}
			sb.append("#").append(i).append(" ").append(max).append("\n");
		} // end of tc
		System.out.println(sb);
	}// end of main

}// end of class
