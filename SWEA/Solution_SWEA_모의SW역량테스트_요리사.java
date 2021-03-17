import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//조합 nCn/2
 class Solution_SWEA_모의SW역량테스트_요리사{
	private static int N, R;
	private static boolean[] used;
	private static int[][] synergy;
	private static int[] A, B;
	private static int min ;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());// 테케
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <=TC; t++) {// 테케 만큼 돈다.
			
			N = Integer.parseInt(br.readLine());// 입력받은 재료의 개수
			R = N / 2;// A음식과 B음식에 각각 들어갈 개수
			synergy = new int[N][N]; // 재료의 시너지 배열
			used = new boolean[N];// 재료 사용여부
			min = Integer.MAX_VALUE;
			A = new int[R]; // A음식 모임
			B = new int[R];// B음식 모임
			// 배열 입력
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			com(0, 0);
			
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}// end of main
// a 배열고르기

	private static void com(int cnt, int start) {// 현재까지의 수, 그다음 오는 조합,
		// nCn/2
		if (cnt == R) {
			int idx = 0;
			for (int i = 0; i < N; i++) {
				if (!used[i]) {
					B[idx++] = i;
				}
			}
			com2(A, B);
			return;
		}

		for (int i = start; i < N; i++) {
			A[cnt] = i;
			used[i] = true;
			com(cnt + 1, i + 1);
			used[i] = false;
		}

	}

	// a 배열과 b 배열에서 각각 2개씩 골라서 시너지 만들기
	private static void com2(int[] a, int[] b) {
		// a의 시너지의 합
		int synergy_A = 0; // 재료 배열
		int synergy_B = 0; // 재료 배열s
		
		for (int i = 0; i < R; i++) {
			for (int j = i + 1; j < R; j++) {
				synergy_A += synergy[A[i]][A[j]] + synergy[A[j]][A[i]];
				synergy_B += synergy[B[i]][B[j]] + synergy[B[j]][B[i]];
			}
		}

		if (min > Math.abs(synergy_A - synergy_B))
			min = Math.abs(synergy_A - synergy_B);
		
		

		// true인것은 A, false인것은 B

	}

}// end of class
