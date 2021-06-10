import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_2110_공유기설치 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());// 집의 개수
		int C = Integer.parseInt(st.nextToken());// 공유기의 개수

		int[] dis = new int[N];

		for (int i = 0; i < N; i++) {
			dis[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(dis);

		// 각 집집 마다의 거리를 늘려가면서 그럴 경우의 공유기 개수를 count
		int left = 1;
		int right = dis[N - 1] - dis[0];
		int max = 0;

		while (left <= right) {
			int mid = (left + right) / 2;
			int start = dis[0];
			int count = 1;

			// 문제조건
			for (int i = 0; i < N; i++) {// 집집 마다 검색함.
				int d = dis[i] - start;

				if (d >= mid) {// 거리 비교해서 기준인 mid 보다 같거나 크면(문제조건인 최소 거리 때문) count 늘림,
					// 그리고 버블 처럼 index 갱신하면서 연이은 배열의 값 차를 구함
					count++;
					start = dis[i];
				}
			}

			if (count >= C) {// 공유기 개수보다 크면
				max = mid;
				left = mid + 1;
			} else {
				right = mid - 1;// 작으면
			}

		}

		System.out.println(max);

	}// end of main

}// end of class
