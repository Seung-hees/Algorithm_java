package holiday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_11720_숫자의합 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		String line = br.readLine();
		for (int i = 0; i < N; i++) {
			sum += line.charAt(i) - '0';

		}
		
		System.out.println(sum);
	}// end of main

}// end of class
