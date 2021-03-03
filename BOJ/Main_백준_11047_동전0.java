import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_11047_동전0 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 동전 N 종류
		int K = sc.nextInt();// 가치의 합
		int cnt = 0;// 동전의 개수

		int[] arr = new int[N];
		// 동전의 가치 입력
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = N - 1; i >= 0; i--) {
			if (K / arr[i] != 0) {
				cnt += K / arr[i];
				K = K % arr[i];
			}
		}
		System.out.println(cnt);

	}// end of main

}// end of class
