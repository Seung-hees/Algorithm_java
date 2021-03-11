import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_15649_N과M1 {
	private static int[] numbers;
	private static boolean[] isselected;
	private static int M, N;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		isselected = new boolean[N+1];
		numbers =new int[M];

		Com(0);
		System.out.println(sb);
	}// end of main

	public static void Com(int cnt) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;// 종료
		}// 기저조건
		for (int i = 1; i < N+1; i++) {
			if(isselected[i]) {
				continue;
			}
			isselected[i] = true;
			numbers[cnt] = i;
			Com(cnt+1);
			isselected[i] = false;
		}
		
	}

}// end of class
