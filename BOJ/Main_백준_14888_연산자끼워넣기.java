import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_14888_연산자끼워넣기 {

	private static int[] number, op, chosen, result;
	private static int min, max, N, sum = 0;
	static boolean[] isSelected;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		number = new int[N];// 입력되는 수
		op = new int[4];// 연산자 : +,-,x,/ 각각의 개수
		isSelected = new boolean[N - 1];
		result = new int[N - 1];

		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;// 최대 , 최소

		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
			sum += op[i];
		}

		chosen = new int[N - 1];// 선택되는 연산자
		com(0);
		System.out.println(max);
		System.out.println(min);

	}// end of main

	private static void com(int cnt) {

		if (cnt == N - 1) {
			permu(0);// 순열
			return;
		}

		while (sum > 0) {
			for (int i = 0; i < 4; i++) {
				if (op[i] == 0) {// op 연산자의 개수가 0라면 할 필요 없음.
					continue;
				}
				chosen[cnt] = i;// op의 연산자를 넣어줌
				op[i]--;
				sum--;
				com(cnt + 1);

			}
		}

	}

	private static void permu(int cnt) {

		if (cnt == N - 1) {
			//System.out.println(Arrays.toString(result));
			int idx = 0;
			int start = number[0];
			for (int i = 1; i < N; i++) {
				if (result[idx] == 0) {// +
					start+=number[i];
				}
				else if (result[idx] == 1) {// -
					start-=number[i];
				}
				else if (result[idx] == 2) {// *
					start*=number[i];
				}
				else if (result[idx] == 3) {// /
					start/=number[i];
				}
				idx++;

			}
			
			min = Math.min(min, start);
			max = Math.max(max, start);
			

			return;
		}

		for (int i = 0; i < N - 1; i++) {
			if (isSelected[i])
				continue;

			result[cnt] = chosen[i];
			isSelected[i] = true;
			permu(cnt + 1);
			isSelected[i] = false;

		}

	}

}// end of class
