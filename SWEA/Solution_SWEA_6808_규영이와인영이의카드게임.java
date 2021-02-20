package workshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_6808_규영이와인영이의카드게임 {
	static int kyu_win, kyu_score = 0;
	static int kyu_lose, in_score = 0;
	static int[] numbers, kyu, in;
	static boolean[] isSelected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());// 테케
		for (int t = 1; t <= TC; t++) {// 테케 FOR문
			kyu_win = 0;
			kyu_lose = 0;
			boolean[] total_number = new boolean[19];
			kyu = new int[9];// 규영이의 list
			in = new int[9]; // 인영이의 list

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 9; i++) {// 규영 list 삽입.
				kyu[i] = Integer.parseInt(st.nextToken());
				total_number[kyu[i]] = true;
			}
			// 인영이의 list 생성(순서 x)
			int idx = 0;
			for (int i = 1; i < 19; i++) {
				if (!total_number[i]) {
					in[idx] = i;
					idx++;
				}
			}
			numbers = new int[9];// 인영이의 순서 리스트
			isSelected = new boolean[9];

			permutation(0);
			sb.append("#").append(t).append(" ").append(kyu_win).append(" ").append(kyu_lose).append("\n");
		} // end of tc

		System.out.println(sb);
		
	}// end of main

	private static void permutation(int cnt) {

		if (cnt == 9) {
			kyu_score = 0;
			in_score = 0;
			for (int i = 0; i < 9; i++) {
				if (kyu[i] > numbers[i]) {// 규영이가 이기는 경우
					kyu_score += kyu[i] + numbers[i];
				} else if (kyu[i] < numbers[i]) {// 인영이가 이기는 경우
					in_score += kyu[i] + numbers[i];
				}
			}
			if (kyu_score > in_score) {
				kyu_win++;
			} else if (kyu_score < in_score) {
				kyu_lose++;
			}
			// System.out.println(kyu_score + " "+ in_score);

			return;
		} // end of 기저

		for (int i = 0; i < 9; i++) {
			if (isSelected[i])
				continue;

			numbers[cnt] = in[i];
			isSelected[i] = true;
			permutation(cnt + 1);
			isSelected[i] = false;

		}
	}// end of permutation

}// end of class
