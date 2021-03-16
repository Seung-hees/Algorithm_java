import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// bfs
public class Solution_SWEA_1238_Contact {
	
	private static int[][] map;
	private static int[] visited;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <=10; t++) {// 10 번 반복
			StringTokenizer st = new StringTokenizer(br.readLine());
			int data = Integer.parseInt(st.nextToken());// 받아지는 데이터의 크기
			int start = Integer.parseInt(st.nextToken());// 시작점
		
			map = new int[101][101]; // 연락 사람 번호 - 행은 from / 열은 to
			visited = new int[101]; // 연락 사람의 방문 여부
			
			//from to 입력하기 map
			StringTokenizer s = new StringTokenizer(br.readLine());
			for (int d = 0; d < data/2; d++) {// 데이터 만큼 받기
				int from = Integer.parseInt(s.nextToken());
				int to = Integer.parseInt(s.nextToken());
				
				map[from][to] = 1;
			}
			
			
			bfs(start);	// 시작 점 (번호 )에서 부터 탐색
			
			int idx = 0;
			int max = 0;
			for (int i = 1; i <101; i++) {
				if(max<=visited[i]) {
					max = visited[i];
					idx = i;
				}
			}
		
			sb.append("#").append(t).append(" ").append(idx).append("\n");
		}
		
		System.out.println(sb);
		
		
	}// end of main

	public static void bfs(int s) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(s);
		visited[s] = 1;
		
		while(!q.isEmpty()) {
			int n = q.poll();// 해당 번호를 뽑음
			for (int i = 1; i < 101 ; i++) {//to를 찾음
				if(map[n][i] == 1 && visited[i] == 0) {
					q.offer(i);
					visited[i] = visited[n]+1;
				}
			}
		}
		
	}

}// end of class
