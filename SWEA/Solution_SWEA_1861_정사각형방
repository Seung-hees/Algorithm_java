import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 모든 방에서 출발해보기
 * 2. 방문체크를 할 필요가 없다.
 * 3. 너가 갈수 있는 길 값 더해줌.
 * 4. 메모이제이션 - 결과를 저장, 재사용
 * 
 * DFS , BFS (- 1:N (비선형 자료구조)의 코드 블럭 )로 푸는 문제가 아님.
 * 모든 정점에서 출발해서 다 탐색해봐야함
 * 최대값 구하기(동일한 최대값일 경우, 숫자가 작은 경우를 택한다.)
 * 
 * 메모이제이션
 * 
 */
class Solution {

private static int N;
private static int[][] A;
private static int[][] memo;

public static void main(String[] args) throws Exception {
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 StringBuilder sb = new StringBuilder();
	 int TC = Integer.parseInt(br.readLine());
	 for (int testCase = 1; testCase <= TC; testCase++) {
		 N = Integer.parseInt(br.readLine());
		 A = new int[N][N];
		 memo = new int[N][N];// 탐색한 결과를 저장할 배열
		 
		 for (int i = 0; i < A.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < A.length; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
			
		 }
		 
		 int max = 0; //최대 이동할 수 있는 방의 개수
		 int num = Integer.MAX_VALUE; // 최대 이동을 위해 출발할 방의 위치(숫자)
		
			for (int r = 0; r < A.length; r++) {// 모든 방에서 출발해서 탐색해보자
				for (int c = 0; c < A.length; c++) {
					int val = go(r,c);//r,c 위치에서 출발해서 이동할 수 있는 최대 방의 개수를 리턴
					if(max < val || max == val && num > A[r][c]) {
						max = val;
						num = A[r][c];
						
				}	
			}
		}
		 
			sb.append("#").append(testCase).append(" ").append(num).append(" ").append(max).append("\n");
	}
	 
	System.out.println(sb);
 }
	private static int[] dr = {-1,1,0,0};// 상하좌우
	private static int[] dc = {0,0,-1,1};// 
	
 /** A[r][c] 방에서 출발해서 최대 이동할수 있는 방의 개수를 리턴하는 메서드*/
public static int go(int r, int c) { 
	
	if(memo[r][c] != 0) {// 탐색한 기록이 있는가?
		return memo[r][c]; // 중복 호출 제거
	}
	
	
	memo[r][c] = 1; // 몇 칸 갈수 있는지 저장할 변수
	int num = A[r][c]; // 현재 방의 숫자
	
	for (int i = 0; i < 4; i++) {
		int nr = r+dr[i];
		int nc = c+dc[i];
		
		
		if(0<=nr&& nr<N && 0<=nc && nc<N && A[nr][nc] == num+1) {
			memo[r][c] += go(nr,nc);
			break; // 외길이니까
		}
	}
	return memo[r][c];
}
}
