import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1182_부분수열의합 {
	private static int[] number;
	private static int N;
	private static int S;
	private static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());// 정수의 개수
		S = Integer.parseInt(st.nextToken());// 정수의 합

		number = new int[N];
		isSelected = new boolean[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}

		subset(0, 0);
		System.out.println(result);

	}// end of main

	private static int result = 0;

	private static void subset(int cnt, int sum) {
		if (cnt == N) {
			boolean chk = false;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {// 공집합 없어야 함.
					chk = true;
				}
			}
			if (chk && sum == S) {
				result++;
			}
			return;
		}
		// 선택
		// System.out.println(cnt);
		isSelected[cnt] = true;
		subset(cnt + 1, sum + number[cnt]);

		// 비선택
		isSelected[cnt] = false;
		subset(cnt + 1, sum);

	}

}// end of class
