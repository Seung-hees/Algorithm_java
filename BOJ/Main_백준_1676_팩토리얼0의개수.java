import java.util.Scanner;


public class Main_백준_1676_팩토리얼0의개수 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int two = 0;
		int five = 0;
		for (int i = n; i >= 1; i--) {
			int t = i;
			while (true) {
				if (t % 2 != 0 && t % 5 != 0) {
					break;
				}

				if (t % 10 == 0) {
					t /= 10;
					two++;
					five++;
				}

				if (t % 2 == 0) {
					t /= 2;
					two++;
				}

				if (t % 5 == 0) {
					t /= 5;
					five++;
				}

			}
		}

		System.out.println(Math.min(two, five));

	}// end of main
}// end of class
