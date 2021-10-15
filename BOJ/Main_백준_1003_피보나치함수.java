import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_1003_피보나치함수 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());// 테케

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			if (N == 1) {
				System.out.println(0 + " " + 1);
				continue;
			}
			if (N == 0) {
				System.out.println(1 + " " + 0);
				continue;
			}

			int a = 1;
			int b = 0;
			int c = 0;// 0일 때 : 초기화

			int x = 0;
			int y = 1;
			int z = 0;// 1일  : 초기화

			for (int i = 2; i <= N; i++) {
				c = a + b;
				a = b;
				b = c;

				z = x + y;
				x = y;
				y = z;
			}
			System.out.println(c + " " + z);

		}

	}

}// end of class
