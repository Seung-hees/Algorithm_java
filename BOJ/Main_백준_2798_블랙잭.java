package workshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2798_블랙잭 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());// 카드의 개수
		int card_sum = Integer.parseInt(st.nextToken()); // 카드의 합
		int max = 0;// 카드합 최대
		int sum = 0;
		int[] card = new int[N];// 카드가 들어있는 배열
		StringTokenizer s = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(s.nextToken());
		}

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				for (int k = j + 1; k < N; k++) {
					sum = card[i] + card[j] + card[k];
					if (sum > max && sum <= card_sum)// 카드 합이 맥스보다 크고 카드 최종 값들보다 작을 때
						max = sum;// 바꿔줌
					sum = 0;// 다시 리셋
				}
			}
		}
		
		
		System.out.println(max);
		

	}// end of main

}// end of class
