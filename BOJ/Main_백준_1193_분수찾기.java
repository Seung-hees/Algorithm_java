package holiday;

import java.util.Scanner;

public class Main_백준_1193_분수찾기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int cha = 0;
		int line = 0;

		while (N > line) {
			cha++;
			line += cha;
		}

		int cnt = line - N;

		if (cha % 2 != 0) {// 홀수이면
			int h = 1; // 가로
			int v = cha;// 세로
			for (int i = 0; i < cnt; i++) {
				h++;
				v--;
			}
			System.out.println(h + "/" + v);
		} else if (cha % 2 == 0) {// 짝수이면
			int h = cha; // 가로
			int v = 1;// 세로
			for (int i = 0; i < cnt; i++) {
				h--;
				v++;
			}
			System.out.println(h + "/" + v);

		}
	}// end of main

}// end of class
