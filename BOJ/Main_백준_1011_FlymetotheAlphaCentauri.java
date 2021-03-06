/** 시간 초과 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1011_FlymetotheAlphaCentauri {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());// tc
		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int cnt = 1;// 이동횟수 (맨 마지막 y 이전은 1로 이동)
			int x = Integer.parseInt(st.nextToken());// 출발점 x
			int y = Integer.parseInt(st.nextToken());// 도착지점 y

			int k = 1;// k시작 (k,k-1,k-2)

			while (x != (y - 1)) {// 출발지점이 y-1 까지 도착
				c: for (int j = 0; j <= 2; j++) {// 1,0,-1 큰 지점부터 확인
					int s = k - j;
					if ((y - 1) >= (x + s)) {// x에서 k만큼 더했을 때 y와의 거리 확인
						x += s;
						cnt++;// 이동횟수 카운트
						break c;
					}

				}
				k++;

			} // end of while

			sb.append(cnt + "\n");

		} // end of tc
		System.out.println(sb);
	}// end of main
}// end of class
