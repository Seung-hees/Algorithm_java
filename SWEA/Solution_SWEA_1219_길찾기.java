import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1219_길찾기 {
	private static int[] size1 = new int[100];
	private static int[] size2 = new int[100];
	private static int result;
	
	

	public static void main(String[] args) throws Exception  {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		
		
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int k = Integer.parseInt(st.nextToken());// 버림
			int d = Integer.parseInt(st.nextToken());// 데이터의 개수
			// 배열 초기화
			for (int s = 0; s < 100; s++) {
				size1[s] = 0;
				size2[s] = 0;
			}

			result = 0;
			
			StringTokenizer s = new StringTokenizer(br.readLine()," ");//데이터 삽입
			for (int i = 0; i < d; i++) {
				
				int start = Integer.parseInt(s.nextToken());
				int end = Integer.parseInt(s.nextToken());
				
				if(size1[start] == 0) {
					size1[start] = end;
				}else {
					size2[start] = end;
				}
				
			}
			
			dfs(0);	
			sb.append("#").append(t).append(" ").append(result).append("\n");
			
		}
		
		
		System.out.println(sb);
		

	}//end of main

	private static void dfs(int a) {
		
		if(a == 99) {
			result = 1;
			return;
		}
		
		if(size1[a]!=0) {
			dfs(size1[a]);
		}
		if(size2[a]!=0) {
			dfs(size2[a]);
		}
		
		
	}
}//end of class
