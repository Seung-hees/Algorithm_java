import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_πÈ¡ÿ_14891_≈È¥œπŸƒ˚ {
	private static int[][] topni;

	public static void main(String[] args) throws IOException {
		// N±ÿ 0,S±ÿ 1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		topni = new int[5][8];
		String str = "";

		for (int i = 1; i < 5; i++) {
			str = br.readLine();
			for (int j = 0; j < 8; j++) {
				topni[i][j] = str.charAt(j) - '0';
			}
		}

		int K = Integer.parseInt(br.readLine());// »∏¿¸»Ωºˆ
		for (int i = 0; i < K; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken()); // Ω√∞Ë : 1, π›Ω√∞Ë : -1

			solution(num, dir);
		}

		int sum = 0;
		if (topni[1][0] == 1) {
			sum += 1;
		}
		if (topni[2][0] == 1) {
			sum += 2;
		}
		if (topni[3][0] == 1) {
			sum += 4;
		}
		if (topni[4][0] == 1) {
			sum += 8;
		}
		System.out.println(sum);

	}// end of main

	private static void solution(int num, int dir) {
		left(num - 1, -dir);
		right(num + 1, -dir);
		rotate(num, dir);
	}

	private static void left(int num, int dir) {

		// øﬁ¬ ¿∏∑Œ ¬ﬂ∞°±‚
		if (num < 1) {
			return;
		}

		if (topni[num][2] != topni[num + 1][6]) {
			left(num - 1, -dir);
			rotate(num, dir);
		} else {
			return;
		}

	}

	private static void right(int num, int dir) {
		// ø¿∏•¬ 

		if (num > 4)
			return;

		// ø¿∏•¬ ¿∏∑Œ ¬ﬂ ∞°±‚
		if (topni[num][6] != topni[num - 1][2]) {
			right(num + 1, -dir);
			rotate(num, dir);
		} else {
			return;
		}

	}

	private static void rotate(int idx, int n) {// Ω√∞Ë
		if (n == 1) {
			int tmp = topni[idx][7];
			for (int j = 7; j > 0; j--) {
				topni[idx][j] = topni[idx][j - 1];
			}
			topni[idx][0] = tmp;
		} else {
			int tmp = topni[idx][0];
			for (int j = 0; j < 7; j++) {
				topni[idx][j] = topni[idx][j + 1];
			}
			topni[idx][7] = tmp;

		}

	}

}// end of class
