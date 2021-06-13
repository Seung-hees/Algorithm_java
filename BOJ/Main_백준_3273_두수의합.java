import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_3273_두수의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int x = Integer.parseInt(br.readLine());

		Arrays.sort(arr);

		int left = 0;
		int right = n - 1;
		int cnt = 0;

		while (left < right) {
			int sum = arr[left] + arr[right];
			if (sum == x) {
				cnt++;
			}
			if (sum <= x) {// 값을 증가시켜주어야 함.
				left++;
			} else {// 값을 감소 시켜주어야 함.
				right--;
			}

		}

		System.out.println(cnt);

	}// end of main
}// end of class
