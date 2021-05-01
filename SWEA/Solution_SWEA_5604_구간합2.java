import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_5604_구간합2 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			long A = Long.parseLong(st.nextToken()); // A~B 둘다 포함
			long B = Long.parseLong(st.nextToken());
			// int result = function(B) - function(A);
			long[] number = new long[10];// 0~9
			long result = 0;
			long mul = 1;

			if (A == 0) {
				A = 1;
			}
			while (A <= B) {
				while (A % 10 != 0 && A <= B) {
					for (long i = A; i > 0; i /= 10) {
						String s = Long.toString(i);
						int t1 = s.charAt(s.length() - 1) - '0';
						number[t1] += mul;
					}
					A++;
				}
				if (A > B)
					break;

				while (B % 10 != 9 && A <= B) {
					for (long i = B; i > 0; i /= 10) {
						String s = Long.toString(i);
						int t1 = s.charAt(s.length() - 1) - '0';
						number[t1] += mul;
					}
					B--;
				}
				long diff = B / 10 - A / 10 + 1;
				for (int i = 0; i < 10; i++)
					number[i] += diff * mul;
				mul *= 10;
				A /= 10;
				B /= 10;

			}
			for (int i = 1; i < 10; i++)
				result += (i * number[i]);
			System.out.println("#" + t + " " + result);

		}

	}// end of main


}// end of class
