import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3289_서로소집합 {

	static int N, M;
	static int parents[];

	static void make() {// 크기가 1인 단위집합을 만든다.
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}

	}

	static int findSet(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = findSet(parents[a]);

	}

	static boolean union(int a, int b) {

		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());// 1~n까지의 수
			M = Integer.parseInt(st.nextToken());// m번의 연산

			parents = new int[N + 1];
			make();

			for (int i = 0; i < M; i++) {
				StringTokenizer s = new StringTokenizer(br.readLine(), " ");
				int op = Integer.parseInt(s.nextToken());

				switch (op) {
				case 0:// 두 집합을 합친다는 의미
					int a = Integer.parseInt(s.nextToken());
					int b = Integer.parseInt(s.nextToken());

					union(a, b);

					break;
				case 1:// 두 집합에 포함되어 있는 지 확인
					int c = Integer.parseInt(s.nextToken());
					int d = Integer.parseInt(s.nextToken());

					if (findSet(c) == findSet(d)) {
						sb.append("1");// 같은 집합 속해 있다면
					} else {
						sb.append("0");
					}

					break;

				}

			}

			System.out.println(sb);
		} // end of tc

	}// end of main

}// end of class
