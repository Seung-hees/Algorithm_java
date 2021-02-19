package workshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2775_부녀회장이될테야 {

	static int sum = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {

			int k = Integer.parseInt(br.readLine());// k층
			int n = Integer.parseInt(br.readLine());// n호
			System.out.println(apt(k, n));

		}

	}// end of main

	private static int apt(int k, int n) {
		int sum = 0;
		if (k == 0)
			return n;
		else {
			for (int i = 1; i <= n; i++) {
				sum += apt(k - 1, i);

			}
			return sum;
		}
	}

}// end of class
