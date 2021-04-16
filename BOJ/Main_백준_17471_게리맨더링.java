import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 인접 리스트 만들기
// 인구 수끼리 연결
// N 개의 구역을 2개의 선거구로 나누어줘야 함. (1개뽑는 조합과 N-1 개 뽑는 조합의 인구차 값은 동일하므로 1~(N+1)/2 개까지만 뽑음
// 선거구 조건 - 1. 최소 1개의 구역을 포함하고 있어야 함, 2. 포함된 구역들은 서로 연결되어 있어야 함.
// 나눠진 두 지역구의 인구 차이의 최솟값
public class Main_백준_17471_게리맨더링 {

	private static ArrayList<ArrayList<Integer>> city;
	private static int[] people;
	private static boolean[] visited;
	private static int sum = 0;// 전체 도시 인구 수
	private static int min = Integer.MAX_VALUE;// 최댓값
	private static int N;
	private static int[] result;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		people = new int[N + 1];
		visited = new boolean[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			sum += people[i];
		}

		city = new ArrayList<>();

		// 인접 리스트로 구성한 그래프에 ArrayList를 넣어주면서 초기화
		for (int i = 0; i <= N; i++) {
			city.add(new ArrayList<>());
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int cnt = Integer.parseInt(st.nextToken());
			for (int c = 0; c < cnt; c++) {
				city.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		// 인접리스트 적용 완료

		// 조합 시작!
		for (int i = 1; i < N / 2 + 1; i++) {
			result = new int[i];
			combcity(0, 0, i, result);// 조합
		}

		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}

	}// end of main

	private static void combcity(int start, int cnt, int n, int[] arr) {

		if (cnt == n) {
			// 두 선거구로 나누기 성공
			// 연결되어 있는 지 확인
			if (bfs(visited)) {
				int vote = 0;
				for (int i = 0; i < arr.length; i++) {
					vote += people[arr[i]];
				}
				vote = Math.abs((sum - vote) - vote);
				min = Math.min(min, vote);
			}

			return;
		}

		for (int i = 1; i <= N; i++) {// 도시에 넣을 것

			if (visited[i])
				continue;

			arr[start] = i;
			visited[i] = true;
			combcity(start + 1, cnt + 1, n, arr);
			visited[i] = false;

		}

	}

	private static boolean bfs(boolean[] vis) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N + 1];

		// true 로 되어 있는 것들
		for (int i = 1; i <= N; i++) {
			if (vis[i]) {
				q.offer(i);
				visited[i] = true;
				break;
			}
		}

		while (!q.isEmpty()) {
			int p = q.poll();

			for (int i = 1; i <= N; i++) {
				if (city.get(p).contains(i) && !visited[i] && vis[i]) {
					visited[i] = true;
					q.offer(i);
				}

			}
		}

		for (int i = 1; i <= N; i++) {
			if (visited[i] != vis[i])
				return false;
		}

		Arrays.fill(visited, true);

		// false 로 되어 있는 것들 = > 0 제외

		for (int i = 1; i <= N; i++) {
			if (!vis[i]) {
				q.offer(i);
				visited[i] = false;
				break;
			}
		}

		while (!q.isEmpty()) {
			int p = q.poll();

			for (int i = 1; i <= N; i++) {
				if (city.get(p).contains(i) && visited[i] && !vis[i]) {
					visited[i] = false;
					q.offer(i);
				}

			}
		}

		for (int i = 1; i <= N; i++) {
			if (visited[i] != vis[i])
				return false;
		}

		return true;
	}

}// end of class
