import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
// 개수를 세는 것이 아니라 , 가장 왼쪽에 위치 한 값과 가장 오른쪽에 위치 한 값의 인덱스 차를 통해 개수를 구한다.

public class Main_백준_10816_숫자카드2 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

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
			int n = Integer.parseInt(st.nextToken());
			sb.append(upperbinarySearch(arr, n) - lowerbinarySearch(arr, n)).append(" ");

		}

		System.out.println(sb.toString());
	}// end of main

	private static int upperbinarySearch(int[] list, int key) {

		int left = 0;
		int right = list.length;

		while (left < right) {
			int mid = (left + right) / 2;
			if (list[mid] <= key) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;

	}

	private static int lowerbinarySearch(int[] list, int key) {

		int left = 0;
		int right = list.length;

		while (left < right) {
			int mid = (left + right) / 2;

			if (list[mid] >= key) {
				right = mid;

			}else {
				left = mid + 1;
			}
		}
		return left;
	}

}// end of class
