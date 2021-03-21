import java.util.Scanner;

// 재귀
 class Solution {
	static int[][] arr; 
	static int result;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int tc = 0; tc < testCase; tc++) {
			
			int N = sc.nextInt();
			
			arr = new int[N][N];
			result = 1; // 1부터 시작
			
			int idx = 0;//index는 재귀 때 하나씩 증가
			int size = N; //끝나는 index size는 1씩 감소
			
			edge(idx,size);
			System.out.println("#"+(tc+1));
			
			/** 배열 출력*/
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}
		
		
		}//end of main
	
	
	public static void edge(int idx, int size) {//c : 몇 *몇 배열 할건지, 
		
		if( size == (idx+1)) {
			arr[idx][idx]= result;
			return;
		}
		
		if( size <= 0) {// c가 0이면 종료
			return;
		}
		//예를들어 c 가 3일 때.
		//1->
				for (int j = idx; j <size-1; j++) {
					arr[idx][j] = result++;
				}
				//2 아래
				for (int i =idx; i <size-1; i++) {
					arr[i][size-1] = result++;
				}
				//3<-
				for (int j = size-1; j > idx ; j--) {
					arr[size-1][j] = result++;
				}
				//4 위
				for (int i = size-1; i > idx; i--) {
					arr[i][idx] = result++;
				}
				//System.out.println(size);
			edge(idx+1,size-1);	
		}
		
	}

