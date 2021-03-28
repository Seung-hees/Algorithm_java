import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_9461_파도반수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] semo = new long[101];
		semo[1] = 1;
		semo[2] = 1;
		semo[3] = 1;
		semo[4] = 2;
		semo[5] = 2;
		for (int i = 6; i < 101; i++) {
			semo[i] = semo[i - 1] + semo[i - 5];
		}

		int TC = Integer.parseInt(br.readLine());

		for (int t = 0; t < TC; t++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(semo[N]);

		}

	}// end of main

}// end of class
