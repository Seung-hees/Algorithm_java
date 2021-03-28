import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1932_정수삼각형 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = N - 1; i >= 1; i--) {// 행은 감소시키면서
			for (int j = 1; j <= i; j++) {
				arr[i][j] = arr[i][j] + Math.max(arr[i + 1][j], arr[i + 1][j + 1]);
			}
		}
		System.out.println(arr[1][1]);

	}// end of main

}// end of class
