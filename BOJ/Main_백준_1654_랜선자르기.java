import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1654_랜선자르기 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		long K = Long.parseLong(st.nextToken());// 필요한 랜선의 개수

		long[] arr = new long[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		Arrays.sort(arr);
		// 인덱스가 아니라 값!!
		long start = 1;
		long end = arr[N - 1];
		long maxLen = Long.MIN_VALUE;

		while (start <= end) {

			long cut = (start + end) / 2; // 랜선 자를 단위
			long num = 0;
			for (int i = 0; i < arr.length; i++) {
				num += (arr[i] / cut);// 이미 있는 랜선을 단위에 따라 자른 갯수
			}
			// 필요한 랜선 개수인 K보다 작은가?
			if (num < K) {
				// 더 잘게 나눠지도록 범위를 작게 하기
				end = cut - 1;
			}
			// 랜선 개수 K보다 더 큰가
			else if (num > K) {
				// 그럼 그중에서도 가장 최대 길이를 쓰자.
				maxLen = Math.max(maxLen, cut);
				start = cut + 1;
			} else {
				maxLen = cut;
				start = cut + 1;
			}

		}
		System.out.println(maxLen);

	}// end of main

}// end of class
