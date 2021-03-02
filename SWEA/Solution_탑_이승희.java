import java.util.Arrays;
import java.util.Scanner;

public class Solution_IM_이승희 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int t = 1; t <= TC; t++) {

			int N = sc.nextInt();
			int m1 = sc.nextInt();
			int m2 = sc.nextInt();

			int[] arr = new int[N];// 각 블럭의 무게들
			int[] M1 = new int[m1];// M1 탑
			int[] M2 = new int[m2];// M2 탑

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			Arrays.sort(arr); // 정렬
			
			int M1_idx = 0;
			int M2_idx = 0;
			int arr_idx = N - 1;

			c: while (true) {
				M1[M1_idx++] = arr[arr_idx--];
				if (M1_idx == m1) {
					for (int i = arr_idx; i >= 0; i--) {
						M2[M2_idx++] = arr[i];
					}
					break c;
				}

				M2[M2_idx++] = arr[arr_idx--];
				if (M2_idx == m2) {
					for (int i = arr_idx; i >= 0; i--) {
						M1[M1_idx++] = arr[i];
					}
					break c;
				}

			} // end of while

			int sum = 0;
			for (int i = 0; i < m1; i++) {// M1 계산
				sum += M1[i] * (i + 1);
			}
			for (int i = 0; i < m2; i++) {// M2 계산
				sum += M2[i] * (i + 1);
			}

			System.out.println("#" + t + " " + sum);

		}

	}// end of class

}// end of main
