import java.util.Scanner;

public class Main_백준_2004_조합0의개수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long m = sc.nextLong();

		long five = 0;
		long two = 0;

		five += Countfive(n);
		two += Counttwo(n);

		five -= Countfive(n - m);
		two -= Counttwo(n - m);

		five -= Countfive(m);
		two -= Counttwo(m);

		System.out.println(Math.min(five, two));

	}// end of main

	private static long Counttwo(long n) {// 2의 개수 세기
		long cnt = 0;
		for (long i = 2; i <= n; i *= 2) {
			cnt += n / i;
		}
		return cnt;
	}

	private static long Countfive(long n) {
		long cnt = 0;
		for (long i = 5; i <= n; i *= 5) {
			cnt += n / i;
		}

		return cnt;
	}

}// end of class
