import java.util.Scanner;

class Solution{

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		//테스트케이스
			for (int t = 0; t < 10; t++) {
				int tc = sc.nextInt();
				
				int[][] arr = new int[100][100];// 사다리 배열
				boolean[][] visited = new boolean[100][100]; // 방문 확인 배열
				
				
				//사다리 입력 받기
				for (int i = 0; i < 100; i++) {
					for (int j = 0; j < 100; j++) {
						arr[i][j] = sc.nextInt();
					}	
				}
				
				//시작지점 99 ,start
				int start = 0;
				
				// 맨 마지막 줄 '2'확인 
				for (int i = 0 ; i<100; i++) {
					if(arr[99][i] == 2) {
						start = i;
					}
				}
				int x = 99; // 행 시작점
				int y = start; // 열 시작점
				
				
				while(true) {
					
					if(x == 0) {
						break;
					}
					
					
					visited[x][y] = true;
					
					// 좌 확인
					if( y-1>=0 && arr[x][y-1] == 1 && visited[x][y-1] == false) {
						y--;		
					}
					// 우 확인
					else if(y+1<=99 && arr[x][y+1] == 1 && visited[x][y+1] ==false) {
						y++;
						
					}
					// 위 확인
					else if(x-1 >=0 && arr[x-1][y] == 1 && visited[x-1][y] == false) {
						x--;		
					}
				}
				
				System.out.println("#"+tc+" "+y);
				
			}		
	} // end of main
}//end of class
