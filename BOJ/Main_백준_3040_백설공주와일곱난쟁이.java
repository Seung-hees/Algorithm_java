package workshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//9C7

public class Main_백준_3040_백설공주와일곱난쟁이 {
	static int[] seven, boys;
	static int total = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 아홉 난쟁이
		boys = new int[9];
		for (int i = 0; i < 9; i++) {
			boys[i] = Integer.parseInt(br.readLine());
		}

		seven = new int[7];// 일곱난쟁이 자리

		combination(0,0,0);

	}// end of main

	private static void combination(int cnt,int start,int sum) {

		if (cnt == 7 ) {
			if(sum == 100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(seven[i]);
				}
			}
			return;
		}

		for (int j = start; j < 9; j++) {
			seven[cnt] = boys[j];
			combination(cnt+1,j+1,sum+boys[j]);

		}

	}

}// end of class
