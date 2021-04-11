import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_11724_연결요소의개수 {
	private static boolean[] visited;
	private static int N;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());// 정점의 개수
		int M = Integer.parseInt(st.nextToken());// 간선의 개수 
		
		map = new int[N+1][N+1];
		visited = new boolean[N+1];// 방문 확인
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			map[start][end] = 1;
			map[end][start] = 1;
		}
		int level = 0;
		// 입력완료
		//dfs 로 탐색
		for (int i = 1; i <N+1 ; i++) {
			if(!visited[i]) {
				dfs(i);
				level++;
			}
		}
		System.out.println(level);

	}// end of main

	private static void dfs(int x) {
		visited[x] = true;
		
		for (int k = 1; k < N+1; k++) {
			if(map[x][k] == 1 && !visited[k]) {
				dfs(k);
			}
		}
		
	}

}// end of class
