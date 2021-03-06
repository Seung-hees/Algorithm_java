import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * d=1 1 d=2 11 d=3 111 d=4 121 d=5 1211 d=6 1221 d=7 12211 ... d=21 12344321 직접
 * 찾아보고 규칙으로 풀기
 */
public class Main_백준_1011_FlymetotheAlphaCentauri2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());// tc
		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int cnt = 0;// 이동횟수 (맨 마지막 y 이전은 1로 이동)
			int x = Integer.parseInt(st.nextToken());// 출발점 x
			int y = Integer.parseInt(st.nextToken());// 도착지점 y
			int k = 1;
			while (true) {
				
				x += k;
				cnt++;
				if (x >= y)
					break;
				
				y -= k;
				cnt++;
				if (y <= x)
					break;

				k++;

			}

			sb.append(cnt + "\n");

		} // end of tc
		System.out.println(sb);
	}// end of main
}// end of class
