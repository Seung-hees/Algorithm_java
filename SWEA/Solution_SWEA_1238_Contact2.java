import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// bfs
public class Solution_SWEA_1238_Contact2 {
	
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
			

			
			int maxidx = 0;
			int maxcnt = 0;
			
			boolean[]  v = new boolean[101];
			Queue<int[]> q = new LinkedList<int[]>();
			
			v[start] = true;
			
			q.offer(new int[] {start,0});// 정점번호 , 길이
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				int i = cur[0];
				int c = cur[1];
				if(maxcnt<c || maxidx<i) {
					maxcnt=c;
					maxidx=i;
				}
				for (int j = 1; j <101; j++) {
					if(!v[j] && map[i][j] == 1) {
						v[j] = true;
						q.offer(new int[] {j,c+1});// 정점번호 , 길이
					}
				}
				
			}
			
		
			sb.append("#").append(t).append(" ").append(maxidx).append("\n");
		}
		
		System.out.println(sb);
		
		
	}// end of main

}// end of class
