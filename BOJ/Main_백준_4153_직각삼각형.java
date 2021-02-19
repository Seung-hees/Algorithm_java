package hw;

import java.util.Scanner;

public class Main_백준_4153_직각삼각형 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			if (a == 0 && b == 0 && c == 0)
				break;

			if (a > b && a > c && a * a == b * b + c * c) {
				flag = true;
			}
			if (b > a && b > c && b * b == a * a + c * c) {
				flag = true;
			}
			if (c > a && c > b && c * c == b * b + a * a) {
				flag = true;
			}

			if (flag)
				System.out.println("right");
			else
				System.out.println("wrong");
			
			flag = false;

		}
	}

}
