package holiday;

import java.util.Scanner;

public class Main_백준_10809_알파벳찾기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		char[] array = word.toCharArray();
		boolean flag = false;

		for (int i = 97; i < 123; i++) {
			for (int j = 0; j < array.length; j++) {
				if (i == array[j]) {
					System.out.print(j + " ");
					flag = true;
					break;
				}
			}
			if (flag == false) {
				System.out.print(-1 + " ");
			}
			flag = false;
		}

	}// end of main

}// end of class
