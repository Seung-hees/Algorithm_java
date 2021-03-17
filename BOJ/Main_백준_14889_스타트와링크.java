import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_14889_스타트와링크 {

	private static int[] A, B;
	private static int[][] map;
	private static int N,min = Integer.MAX_VALUE;
	private static boolean[] used;

	public static void main(String[] args) throws Exception {
		// numbers = 1~N
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];// 능력치 맵
		used = new boolean[N + 1];// 숫자 사용여부 , 1부터 !
		A = new int[N / 2];// 조합 n/2 개 뽑기 , 스타트팀
		B = new int[N / 2];// 조합 n/2 개 뽑기, 링크팀

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		com(0, 1);
		System.out.println(min);

	}// end of main

	private static void com(int cnt, int start) {

		if (cnt == N / 2) {
			int idx = 0;
			for (int i = 1; i <= N; i++) {
				if (!used[i]) {
					B[idx++] = i;
				}
			}
			//System.out.println(Arrays.toString(A));
			//System.out.println(Arrays.toString(B));
			synergy(A,B);
			//System.out.println();
			return;
		}

		for (int i = start; i <= N; i++) {
			A[cnt] = i;
			used[i] = true;
			com(cnt + 1, i + 1);
			used[i] = false;
		}

	}

	public static void synergy(int[] a, int[] b) {
		int A_sum = 0;// 스타트합
		int B_sum = 0;// 링크합
		

		for (int i = 0; i < N/2; i++) {
			for (int j = i + 1; j < N/2; j++) {
				A_sum += map[A[i]-1][A[j]-1] + map[A[j]-1][A[i]-1];
				B_sum += map[B[i]-1][B[j]-1] + map[B[j]-1][B[i]-1];
			}
		}

		if (min > Math.abs(A_sum - B_sum))
			min = Math.abs(A_sum - B_sum);
		
		
		
	}

}// end of class
