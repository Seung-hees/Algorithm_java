import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_2805_나무자르기 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());// 나무의 수
		int M = Integer.parseInt(st.nextToken());// 적어도 잘라야 하는 M미터
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int left = 1;// 최소값
		int right = arr[N - 1];// 최대값
		long len = 0;

		while (left <= right) {
			int mid = (left + right) / 2;
			long sum = 0;

			for (int i = 0; i < N; i++) {
				if (arr[i] >= mid) {
					sum += (arr[i] - mid);
				}

			}

			if (sum >= M) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		} // end of while
		System.out.println(right);

	}// end of main

}// end of class
