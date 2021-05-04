import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 시간초과
public class Main_백준_1010_다리놓기 {

	private static int N;
	private static int M;
	private static boolean[] visited;
	private static int result = 0;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			result = 0;

			visited = new boolean[M];

			select(0, 0);
			System.out.println(result);

		} // end of tc

	}// end of main

	private static void select(int idx, int cnt) {

		if (idx == M && cnt == N) {
			result++;
			return;
		} else if (idx == M) {
			return;
		}

		visited[idx] = true;
		select(idx + 1, cnt + 1);
		visited[idx] = false;
		select(idx + 1, cnt);

	}

}// end of class
