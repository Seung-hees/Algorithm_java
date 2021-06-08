import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1920_수찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			System.out.println(binarySearch(arr, Integer.parseInt(st.nextToken())));
		}

		//System.out.println(Arrays.toString(arr));
	}// end of main

	private static int binarySearch(int[] A, int n) {

		int first = 0;
		int last = A.length - 1;
		int mid = 0;

		while (first <= last) {
			mid = (first + last) / 2;

			if (n == A[mid]) {
				return 1;// 존재
			} else {
				if (n < A[mid]) {
					last = mid - 1;
				} else {
					first = mid + 1;
				}
			}
		}

		return 0;// 존재 하지 않음

	}

}// end of class
