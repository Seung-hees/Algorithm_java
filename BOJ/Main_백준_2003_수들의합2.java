import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2003_수들의합2 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());// 수열의 수
		int M = Integer.parseInt(st.nextToken());// 수

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// System.out.println(Arrays.toString(arr));
		int left = 0;
		int right = 0;
		int cnt = 0;

		while (left != N && right != N) {
			int sum = 0;
			for (int i = left; i <= right; i++) {
				sum += arr[i];
			}
			if (sum == M) {
				cnt++;
			}

			if (right == N) {
				break;
			}

			if (sum < M) {
				right++;
			} else {
				left++;
			}
		} // end of while

		System.out.println(cnt);

	}// end of main

}// end of class
