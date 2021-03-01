package holiday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_7568_덩치 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());// 몇 명인지
		int[][] person = new int[N][2];// N명의 몸무게, 키
		int[] score = new int[N];// 자신의 등수
		
		
		// 입력
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			person[i][0] = Integer.parseInt(st.nextToken());//몸무게
			person[i][1] = Integer.parseInt(st.nextToken());// 키
		}
		
		//비교
		for (int i = 0; i <N; i++) {
			score[i] = 1;// 자기 자신 count
			for (int j = 0; j < N; j++) {// 다른 사람
				if(person[j][0]>person[i][0] && person[j][1]>person[i][1]) {
					score[i]++;// 등수 밀려남
				}
			}
			System.out.print(score[i]+" ");
		}
		
		
		
		
	}// end of main

}// end of class
