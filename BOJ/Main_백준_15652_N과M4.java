import java.util.Scanner;

public class Main_백준_15652_N과M4 {
	private static StringBuilder sb;
	private static int M,N;
	private static int[] numbers;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();
		
		numbers = new int[M];
		
		com(0,1);
		System.out.println(sb);
		
	}// end of main

	private static void com(int cnt, int start) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i <= N; i++) {
			numbers[cnt] = i;
			com(cnt+1,i);
		}
		
		
		
	}

}// end of class
