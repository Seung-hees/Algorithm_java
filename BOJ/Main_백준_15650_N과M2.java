import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_15650_N과M2 {
	private static int[] numbers;
	private static int M, N;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		numbers = new int[M];

		Com(0, 1);
		System.out.println(sb);
	}// end of main

	public static void Com(int cnt, int start) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;// 종료
		} // 기저조건
		for (int i = start; i < N + 1; i++) {
			numbers[cnt] = i;
			Com(cnt + 1, i + 1);
		}

	}

}// end of class
