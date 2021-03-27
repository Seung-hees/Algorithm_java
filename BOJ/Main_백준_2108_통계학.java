import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_2108_통계학 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] newarr = new int[8001];
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
			max = Math.max(arr[i], max);
			min = Math.min(arr[i], min);
			newarr[arr[i] + 4000]++;
		}
		Arrays.sort(arr);

		int result = 0;// 최빈값
		int cnt = 0;// 최빈값 횟수
		boolean flag = false;// 동일한 최빈값 1번만 등장 시, true 아니라면 2번이라면 false ,2번까지만 저장

		for (int i = min+4000; i <= max+4000; i++) {
			if (newarr[i] == 0)
				continue;

			if (cnt < newarr[i]) {
				cnt = newarr[i];
				result = i - 4000;
				flag = true;
			} else if (cnt == newarr[i] && flag) {
				result = i - 4000;
				flag = false;
			}

		}

		// 1. 산술 평균
		sum = (int)Math.round((double)sum / N);
		sb.append(sum).append("\n");
		// 2. 중앙값
		sb.append(arr[((N + 1) / 2) - 1]).append("\n");//0 인것 까지 고려해야함으로
		// 3. 최빈값
		sb.append(result).append("\n");
		// 4. 범위
		sb.append(max - min).append("\n");

		System.out.println(sb);
	}// end of main

}// end of class
