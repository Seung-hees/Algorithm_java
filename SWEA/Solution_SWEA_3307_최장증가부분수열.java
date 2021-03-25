import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_3307_최장증가부분수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {

			int N = Integer.parseInt(br.readLine());// 배열의 길이
			int[] arr = new int[N];// 원소를 저장
			int[] LIS = new int[N];// 각 원소를 마지막에 세웠을 때 최장 길이
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			// 입력완료
			// System.out.println(Arrays.toString(arr));
			int max = 0;
			for (int i = 0; i < N; i++) {
				LIS[i] = 1; // 자기 혼자 세웠을 때의 길이로 초기화
				for (int j = 0; j < i; j++) {
					if (arr[j] < arr[i] && LIS[i] < LIS[j] + 1) {
						LIS[i] = LIS[j] + 1;
					}
				}
				if (max < LIS[i])
					max = LIS[i];
			}

			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}// end of main

}// end of class
