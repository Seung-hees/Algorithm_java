import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_10819_차이를최대로 {

	private static int[] arr;
	private static int N;
	private static int[] number;
	private static int max = Integer.MIN_VALUE;
	private static boolean[] selected;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		number = new int[N];
		selected = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 순열
		Per(0, 0);

		System.out.println(max);

	}// end of main

	private static void Per(int start, int cnt) {
		if (cnt == N) {
			// 최대값
			int sum = 0;
			// System.out.println(Arrays.toString(number));
			for (int i = 0; i < N - 1; i++) {
				sum += Math.abs(number[i] - number[i + 1]);

			}

			max = Math.max(sum, max);

			return;
		}

		for (int i = 0; i < N; i++) {
			if (selected[i])
				continue;

			number[cnt] = arr[i];
			selected[i] = true;
			Per(start + 1, cnt + 1);
			selected[i] = false;
		}

	}

}// end of class
