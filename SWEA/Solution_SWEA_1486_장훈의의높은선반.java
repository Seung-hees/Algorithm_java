import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//직원들의 키 부분 집합 중 가장 선반의 높이 보다 크고 가까운 것
public class Solution_SWEA_1486_장훈의의높은선반 {
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int T;
	static int N, H;
	static int[] heights;
	static int Min;

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			N = Integer.parseInt(tokens.nextToken());// 직원 수
			H = Integer.parseInt(tokens.nextToken());// 선반의 높이

			heights = new int[N];//직원들의 키의 높이
			tokens = new StringTokenizer(input.readLine(), " ");
			for (int i = 0; i < N; i++) {
				heights[i] = Integer.parseInt(tokens.nextToken());
			}
			// System.out.println(Arrays.toString(heights));
			// 입력 완료
			// 부분집합 --> H를 넘는 가장 작은 수?
			Min = Integer.MAX_VALUE;
			//byBitMasking();
			combination(0,  0);
			output.append(String.format("#%d %d%n", t, Min));
		}
		System.out.println(output);
	}

	/** 부분 집합 - 재귀*/
	static void combination(int start, int sum) {

		if (sum >= H && sum - H < Min) {//선반보다 높고 , 키의 합과 선반의 차가 최소 인것
			Min = sum - H;
			return;
		}

		// 기저상황
		if (start == N) {
			return;
		}
		// 재귀 상황
		for (int i = start; i < N; i++) {
			combination(i + 1, sum + heights[i]);
		}
	}

	static void byBitMasking() {
		// 1<<N --> 비트왼쪽으로 --> X2, 이것을 N번 결국 2^n
		for (int i = 1; i < (1 << N); i++) { // i: 요소의 포함 상태를 비트적으로 나타낸다.
			int sum = 0;
			
			for (int j = 0; j < N; j++) {// j에 비트 연산 
				if ((i & (1 << j)) > 0) { // i에 j 비트가 포함되어있다면..
					sum += heights[j];
					// 이미 만족했다면 더 계속 더해줄 필요는 없다.
					if (sum - H > Min) {
						break;
					}
				}
			} // end of for
			
		// H를 넘으면서 차이는 최소화 해주자.
			if (sum >= H && sum - H < Min) {
				Min = sum - H;
			}
		}
	}

}