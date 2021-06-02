import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_1707_이분그래프 {

	private static int V;
	private static ArrayList<ArrayList<Integer>> list;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());// 테케

		for (int t = 0; t < TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());// 정점의 개수
			int E = Integer.parseInt(st.nextToken());// 간선의 개수

			list = new ArrayList<>();// 연결 리스트 생성

			for (int i = 0; i <= V; i++) {
				list.add(new ArrayList<>());// 각각의 리스트안에 새로운 연결리스트 생성
			}

			for (int d = 0; d < E; d++) {
				st = new StringTokenizer(br.readLine(), " ");
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());

				list.get(s).add(e);
				list.get(e).add(s);

			} // end of 간선 입력완료

			// bfs 탐색
			bfs();

		}

	}// end of main

	private static void bfs() {

		boolean flag = true;// 판별
		int[] visited = new int[V + 1];
		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i < V + 1; i++) {
			if (visited[i] == 0) {
				q.offer(i);
				visited[i] = 1;// 방문완료
				// 방문 했을 때 , 그 지점부터 bfs 탐색
				while (!q.isEmpty() && flag) {
					int cur = q.poll();
					for (int j = 0; j < list.get(cur).size(); j++) {// 인접한 것들
						int next = list.get(cur).get(j);
						if (visited[next] == 0) {
							q.offer(next);
							visited[next] = visited[cur] * -1;// 다른색으로 칠하기
						} else if (visited[next] == visited[cur]) {// 색깔이 같을 때
							flag = false;
							break;
						}
					}
				}

			}

		}

		if (flag) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}// end of bfs

}// end of class
