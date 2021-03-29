import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_10844_쉬운계단수 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long[][] arr = new long[N + 1][10];// 0~9 까지

		// 초기화!
		for (int i = 1; i < 10; i++) {
			arr[1][i] = 1;
		}

		// DP
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				if (j - 1 >= 0) {
					arr[i][j] += arr[i - 1][j - 1]%1000000000;
				}
				
				if (j + 1 < 10) {
					arr[i][j] += arr[i - 1][j + 1]%1000000000;
				}
			}

		}

		// 출력
		long cnt = 0;
		for (int i = 0; i < 10; i++) {
			cnt += arr[N][i];
		}

		System.out.println(cnt%1000000000);

	}// end of main

}// end of class
