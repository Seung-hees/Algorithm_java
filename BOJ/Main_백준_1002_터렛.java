package holiday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1002_터렛 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int t = 0; t < TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());

			int dis = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);// 두점사이의 거리

			// 두 점이 같을 때 , 교점 무한
			if (dis == 0 && r1 == r2) {
				// 교점 무한개
				System.out.println(-1);
			}
			// 외접하고 교점이 한개
			else if (dis == ((r1 + r2) * (r1 + r2))) {
				System.out.println(1);
			}

			// 내접하고 교점이 한개
			else if (dis == ((r1 - r2) * (r1 - r2))) {
				System.out.println(1);
			}

			// 외부로 원이 접하지 않을 때
			else if (dis > ((r1 + r2) * (r1 + r2))) {
				System.out.println(0);
			}

			// 내부로 원이 접하지 않을 때
			else if (dis < ((r1 - r2) * (r1 - r2))) {
				System.out.println(0);
			}
			
			// 교점 2개
			else {
				System.out.println(2);
			}

		} // end of tc

	}// end of main
}// end of class
