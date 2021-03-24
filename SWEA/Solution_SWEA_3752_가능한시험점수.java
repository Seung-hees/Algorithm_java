import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3752_가능한시험점수 {
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int T;
	static int N;
	static int score[];
	static boolean visited[];

	static int Answer;

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(input.readLine());
			score = new int[N];// 2,3,5
			tokens = new StringTokenizer(input.readLine(), " ");
			int total = 0;
			for (int i = 0; i < N; i++) {
				score[i] = Integer.parseInt(tokens.nextToken());
				total += score[i];// 점수 총합 만점
			}
			// 맞을 수 있는 점수들을 표현해줄 배열
			visited = new boolean[total + 1];// 만점 배열

			Answer = 0;
			visited[0] = true;// 0점은 언제나 존제한다.
			solve(0, total);
			output.append("#").append(t).append(" ").append(Answer).append("\n");
		}
		System.out.println(output);
	}

	static void solve(int n, int max) {
		if (n == N) {
			for (boolean bool : visited) {
				if (bool) {
					Answer++;
				}
			}
			return;
		}

		for (int i = max; i >= 0; i--) {
			//반드시 뒤에서 부터 수행 해야 한다. max~0 , 0부터 반복문을 돌릴 경우 true로 만들어준 점수가 계속 누적
			// 현 점수가 1점일 경우, 맨 처음의 0과 만나 dp[0+현 기준 점수 1점] = dp[1] = true, 반복의 index가
			// 올라가면서(2,3,4).. 모든 점수가 true가 될것임.
			// 가능한 점수들 마다 , 그 점수 값에서 현재 점수값을 모두 더해준다.
			if (visited[i]) {
				visited[i + score[n]] = true;
			}
		}
		solve(n + 1, max);
	}

}