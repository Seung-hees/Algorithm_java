import java.util.Scanner;

public class Main_백준_1436_영화감독숌 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int start = 666;// 시작
		int cnt = 1;// 카운트

		while (N != cnt) {
			start++;
			if (Integer.toString(start).contains("666")) {
				cnt++;
			}
		}
		System.out.println(start);

	}
}
