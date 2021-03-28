import java.util.Scanner;

public class Main_백준_1904_01타일 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] T = new int[1000001];
		T[1] = 1;
		T[2] = 2;

		for (int i = 3; i < 1000001; i++) {
			T[i] = (T[i - 2] + T[i - 1])%15746;
		}

		System.out.println(T[N]);

	}// end of main

}// end of class
