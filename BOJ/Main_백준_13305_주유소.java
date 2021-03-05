import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_13305_주유소 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());// 도시 개수
		int[] d = new int[N - 1];// 거리
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");// 거리

		for (int i = 0; i < N - 1; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		int[] c = new int[N];// 각 도시의 기름값
		StringTokenizer s = new StringTokenizer(br.readLine(), " ");// 거리

		for (int i = 0; i < N; i++) {
			c[i] = Integer.parseInt(s.nextToken());
		}
		long sum = 0; // 최소 비용
		long min = c[0];
		for (int i = 1; i < N; i++) {
			min = Math.min(min, c[i-1]);
			sum += d[i - 1] * min;
		}

		System.out.println(sum);

	}// end of main
}// end of class
