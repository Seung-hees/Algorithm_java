import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1149_RGB거리 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());// 집의 개수
		
		int[][] house = new int[N][3];// 각집의 빨, 초, 파 로 칠하는 비용
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			house[i][0]  = Integer.parseInt(st.nextToken());// 빨강
			house[i][1]  = Integer.parseInt(st.nextToken());// 초록
			house[i][2]  = Integer.parseInt(st.nextToken());// 파랑
		}
		
		int[][] price = new int[N][3];// 각 가격을 업뎃해줄 DP 배열
		// 초기 설정
		price[0][0] = house[0][0];
		price[0][1] = house[0][1];
		price[0][2] = house[0][2];
		
		for (int i = 1; i < N; i++) {
			price[i][0] = house[i][0]+Math.min(price[i-1][1],price[i-1][2]);//빨강 선택 시 , 초록 파랑
			price[i][1] = house[i][1]+Math.min(price[i-1][2],price[i-1][0]);//빨강 선택 시 , 초록 파랑
			price[i][2] = house[i][2]+Math.min(price[i-1][0],price[i-1][1]);//빨강 선택 시 , 초록 파랑
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			if(min>price[N-1][i]) {
				min = price[N-1][i];
			}
		}
		
		System.out.println(min);
		
		
	}// end of main

}// end of class
