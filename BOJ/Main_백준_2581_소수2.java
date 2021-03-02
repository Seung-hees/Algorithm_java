import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_2581_소수2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		int min = Integer.MAX_VALUE;
		boolean[] arr = new boolean[N + 1];// 0~ N까지 소수 의 정보
		// false 인것이 소수
		arr[0] = true;// 0과 1은 소수가 아님
		arr[1] = true;
		for (int j = 2; j <= Math.sqrt(N); j++) {
			if (arr[j])
				continue;
			for (int k = j * j; k <= N; k = k + j) {
				arr[k] = true;
			}
		}
		
		for (int i = M; i <= N; i++) {
			if (!arr[i]) {
				sum += i;
				if (min == Integer.MAX_VALUE)
					min = i;

			}
		}
		if (sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}

	}// end of main

}// end of class
