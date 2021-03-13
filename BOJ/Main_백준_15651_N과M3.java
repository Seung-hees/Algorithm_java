import java.util.Scanner;

public class Main_백준_15651_N과M3 {
	private static int N;
	private static int M;
	private static int[] numbers;
	private static StringBuilder sb;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		
		N = sc.nextInt();// N개의 자연수중 M개를 고른 수열
		M = sc.nextInt();
		
		numbers = new int[M];// 조합 배열
		
		com(0,1);
		System.out.println(sb);
		
	}//end of main

	public static void com(int cnt,int start) {
		
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		
		for (int i = start; i <= N; i++) {
			numbers[cnt] = i;
			com(cnt+1,1);
		}
		
		
		
		
		
	}

}// end of class
