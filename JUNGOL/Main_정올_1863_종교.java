import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_정올_1863_종교 {
	private static int[] parents;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());// 학생 수
		int m = Integer.parseInt(st.nextToken());

		// 부모 노드 만들기
		parents = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}

		// 서로소 집합 만들기
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}

		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (parents[i] == i)
				cnt++;
		}
		System.out.println(cnt);

	}// end of main

	private static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot)
			return;

		parents[bRoot] = aRoot;
		return;

	}

	private static int findSet(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = findSet(parents[a]);
	}
}// end of class
