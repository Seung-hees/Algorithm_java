import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_14888_연산자끼워넣기2 {

	private static int N;
	private static int result = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	private static int[] op;
	private static int[] number;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		number = new int[N];// 숫자
		op = new int[4];// 연산자

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}

		dfs(1, number[0]);
		System.out.println(max);
		System.out.println(min);

	}// end of main

	private static void dfs(int start, int result) {

		if (start == N) {
			//System.out.println(result);
			min = Math.min(min, result);
			max = Math.max(max, result);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (op[i] == 0)
				continue;
			op[i]--;
			switch (i) {
			case 0:// 덧셈
				dfs(start + 1, result + number[start]);
				break;
			case 1:// 뺄셈
				dfs(start + 1, result - number[start]);
				break;
			case 2:// 곱셈
				dfs(start + 1, result * number[start]);
				break;
			case 3:// 나눗셈
				dfs(start + 1, result / number[start]);
				break;

			}
			op[i]++;

		}

	}

}// end of class
