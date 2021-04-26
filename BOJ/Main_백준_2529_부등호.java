import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_백준_2529_부등호 {
	private static boolean[] visited = new boolean[10];
	private static char[] arr;
	private static int N;
	private static int[] result;
	private static List<String> list = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = st.nextToken().charAt(0);
		}

		// System.out.println(Arrays.toString(arr));

		result = new int[N + 1];

		for (int i = 0; i < 10; i++) {
			visited[i] = true;// 시작점
			result[0] = i;
			dfs(1, 0);
			visited[i] = false;
		}

		Collections.sort(list);

		System.out.println(list.get(list.size()-1));
		System.out.println(list.get(0));

	}// end of main

	private static void dfs(int idx, int ch) {

		if (ch == N) {// 종료

			String s = "";
			for (int i = 0; i < N+1; i++) {
				s += Integer.toString(result[i]);
			}

			list.add(s);
			
			return;

		}

		for (int i = 0; i < 10; i++) {
			if (visited[i]) {
				continue;// 사용중이면 그냥 넘어감ㅣ
			}

			if (arr[ch] == '<' && result[idx - 1] < i) {
				visited[i] = true;
				result[idx] = i;
				dfs(idx + 1, ch + 1);
				visited[i] = false;

			} else if (arr[ch] == '>' && result[idx - 1] > i) {
				visited[i] = true;
				result[idx] = i;
				dfs(idx + 1, ch + 1);
				visited[i] = false;
			}

		}

	}

}// end of class
