import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1449_수리공항승 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 입력 완료
		int res = 0;

		// 정렬
		Arrays.sort(arr);

		int start = 0;// 앞의 인덱스
		int end = N - 1;// 뒤의 인덱스

		while (start <= end) {

			if (arr[end] - arr[start] + 1 > L) {// 그 길이가 크다면
				end -= 1;// 뒤의 인덱스 줄이기

			} else {// 작거나 같다면
				res++;// 결과 +1
				start = end + 1;
				end = N - 1;// 재세팅

			}

		}

		System.out.println(res);

	}// end of main

}// end of class