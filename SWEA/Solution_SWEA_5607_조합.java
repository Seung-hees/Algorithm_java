import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_5607_조합 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());

			System.out.println("#" + t + " " + nCr(N, R, 1234567891));
		}

	}// end of main

	static long nCr(int n, int r, int p) {

		if (r == 0) {
			return 1L;
		}

		long[] fac = new long[n + 1];
		fac[0] = 1;

		for (int i = 1; i <= n; i++) {
			fac[i] = fac[i - 1] * i % p;
		}

		return (fac[n] * power(fac[r], p - 2, p) % p * power(fac[n - r], p - 2, p) % p) % p;
	}

	private static long power(long x, int y, int p) {
		long res = 1L;
		x = x % p;

		while (y > 0) {
			if (y > 0) {
				if (y % 2 == 1) {
					res = (res * x) % p;
				}
				y = y >> 1;
				x = (x * x) % p;
			}
		}
		return res;

	}

}// end of class
