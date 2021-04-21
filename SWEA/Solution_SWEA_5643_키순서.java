import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_5643_키순서 {
	private static int N, result;
	private static ArrayList<ArrayList<Integer>> small;
	private static ArrayList<ArrayList<Integer>> big;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			result = 0;
			N = Integer.parseInt(br.readLine());// 학생 수
			int M = Integer.parseInt(br.readLine());// 비교 횟수

			small = new ArrayList<ArrayList<Integer>>();// 자신보다 작은 것을 저장하는 리스트
			big = new ArrayList<ArrayList<Integer>>();// 자신보다 큰 것을 저장하는 리스트

			for (int i = 0; i <= N; i++) {
				small.add(new ArrayList<>());
				big.add(new ArrayList<>());
			}
			// a b 입력 , a<b

			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				big.get(a).add(b);
				small.get(b).add(a);
			}
			// 입력 종료

			for (int i = 1; i <= N; i++) {
				bfs(i);
			}

			System.out.println("#" + t + " " + result);
		}

	}// end of main

	private static void bfs(int i) {
		int cnt = 0;
		Queue<Integer> qs = new LinkedList<>();
		Queue<Integer> qb = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		qs.offer(i);
		qb.offer(i);
		visited[i] = true;
		cnt++;
		// small 확인
		while (!qs.isEmpty()) {
			int v = qs.poll();

			for (int j = 0; j < small.get(v).size(); j++) {
				int nv = small.get(v).get(j);
				if (!visited[nv]) {
					visited[nv] = true;
					cnt++;
					qs.add(nv);
				}
			}

		}

		// big 확인
		while (!qb.isEmpty()) {
			int v = qb.poll();

			for (int j = 0; j < big.get(v).size(); j++) {
				int nv = big.get(v).get(j);
				if (!visited[nv]) {
					visited[nv] = true;
					cnt++;
					qb.add(nv);
				}
			}
		}

		if (cnt == N)
			result++;
	}

}// end of class
