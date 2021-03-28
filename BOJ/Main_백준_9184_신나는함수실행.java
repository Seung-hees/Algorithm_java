import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_9184_신나는함수실행 {
	public static void main(String[] args) throws IOException {

		int[][][] w = new int[21][21][21];
		// a,b,c 각 값

		for (int b = 0; b < 21; b++) {
			for (int c = 0; c < 21; c++) {
				w[0][b][c] = 1;
			}
		}
		for (int a = 0; a < 21; a++) {
			for (int c = 0; c < 21; c++) {
				w[a][0][c] = 1;
			}
		}
		for (int a = 0; a < 21; a++) {
			for (int b = 0; b < 21; b++) {
				w[a][b][0] = 1;
			}
		}

		for (int a = 1; a < 21; a++) {
			for (int b = 1; b < 21; b++) {
				for (int c = 1; c < 21; c++) {
					if (a < b && b < c) {
						w[a][b][c] = w[a][b][c - 1] + w[a][b - 1][c - 1] - w[a][b - 1][c];
					} else {
						w[a][b][c] = w[a - 1][b][c] + w[a - 1][b - 1][c] + w[a - 1][b][c - 1] - w[a - 1][b - 1][c - 1];
					}

				}
			}
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == -1 && b == -1 && c == -1) {
				break;
			}

			if (a <=0 || b <=0 || c <=0) {
				sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(1).append("\n");
			} else if (a > 20 || b > 20 || c > 20) {
				sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ")
						.append(w[20][20][20]).append("\n");
			} else {
				sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ")
						.append(w[a][b][c]).append("\n");
			}

		}
		System.out.println(sb.toString());

	}// end of main

}// end of class
