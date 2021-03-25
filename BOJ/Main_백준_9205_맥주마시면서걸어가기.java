import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_9205_맥주마시면서걸어가기 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());// 테케

		for (int t = 0; t < TC; t++) {

			int N = Integer.parseInt(br.readLine());// 편의점 개수
			int[][] map = new int[N + 2][2]; // 상근이네 , 편의점 n개 , 락페 총 n+2개의 인접행렬 map[i][0] : x 좌표 , map[i][1] : y좌표(행
												// : from / 열 : to) 위치 저장

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int sx = Integer.parseInt(st.nextToken());// 상근이네
			int sy = Integer.parseInt(st.nextToken());

			// 상근이네 저장
			map[0][0] = sx;
			map[0][1] = sy;
			// 편의점
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				map[i][0] = Integer.parseInt(st.nextToken());
				map[i][1] = Integer.parseInt(st.nextToken());
			}
			// 락페스티벌
			st = new StringTokenizer(br.readLine(), " ");
			map[N + 1][0] = Integer.parseInt(st.nextToken());
			map[N + 1][1] = Integer.parseInt(st.nextToken());
			// 입력 끝
			// 거리 배열

			boolean[][] cost = new boolean[N + 2][N + 2];
		
			
			for (int i = 0; i < N + 2; i++) {// from
				for (int j = 0; j < N + 2; j++) {// to
					if (i == j)
						continue;// 자기자신은 방문 안함
					int dis= Math.abs(map[i][0] - map[j][0]) + Math.abs(map[i][1] - map[j][1]);//거리 저장
					if(dis<=1000) cost[i][j] = true;//50*20 = 1000 보다 크다면 가지 못함. 인접!
				}
			}

			//인접배열 입력완료

			//플로이드
			for (int k = 0; k < N + 2; k++) {//경
				for (int i = 0; i < N + 2; i++) {//출
					for (int j = 0; j < N + 2; j++) { // 도
						if (cost[i][k] && cost[k][j]) {//출->경 / 경->도 모두 true 이면 가능
							cost[i][j] = true;// 
						}
					}
				}
			}
			
			if(cost[0][N+1]) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
			

		}

}// end of main

}// end of class
