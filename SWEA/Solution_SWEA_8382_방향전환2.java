import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_8382_방향전환2 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken()) + 100;
			int y1 = Integer.parseInt(st.nextToken()) + 100;
			int x2 = Integer.parseInt(st.nextToken()) + 100;
			int y2 = Integer.parseInt(st.nextToken()) + 100;

			int r = Math.abs(x1 - x2);// 가로 차
			int c = Math.abs(y1 - y2);// 세로 차
			int min = Math.min(r, c);
			int max = Math.max(r, c);
			// y=x 그래프 라인 이동 거리 + 나머지 직선 이동거리
			int result = 0;
			if ((max - min) % 2 == 0) {
				result = min * 2 + (max - min) * 2;
			} else {
				result = min * 2 + (max - min) * 2 - 1;
			}

			System.out.println("#" + t + " " + result);

		}

	}// end of main

}// end of class
