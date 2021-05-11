import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_3036_링 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N - 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());// 기준
		for (int i = 0; i < N - 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N - 1; i++) {
			int r = gcd(A, arr[i]);
			System.out.println(A / r + "/" + arr[i] / r);
		}

	}// end of main

	private static int gcd(int a, int b) {
		while (true) {
			if (a == 0 || b == 0) {
				break;
			}
			if (a > b) {
				a -= b;
			} else {
				b -= a;
			}

		}
		return a > b ? a : b;
	}

}// end of class
