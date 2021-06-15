import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1717_집합의표현 {

	private static int[] parents;
	private static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parents = new int[N + 1];
		make();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int t = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (t == 0) {
				union(a, b);
			} else {
				if (set(a, b)) {
					sb.append("YES").append("\n");
				} else {
					sb.append("NO").append("\n");
				}
			}

		}
		
		System.out.println(sb.toString());

	}// end of main

	private static boolean set(int a, int b) {
		int aRoot = findset(a);
		int bRoot = findset(b);

		if (aRoot == bRoot) {
			return true;
		} else {
			return false;
		}

	}

	private static int findset(int a) {
		if (parents[a] == a) {
			return a;
		}
		return parents[a] = findset(parents[a]);

	}

	private static boolean union(int a, int b) {
		int aRoot = findset(a);
		int bRoot = findset(b);

		if (aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;

	}

	private static void make() {// 크기가 1인 단위집합 만들기
		for (int i = 0; i < N + 1; i++) {
			parents[i] = i;
		}
	}

}// end of class
