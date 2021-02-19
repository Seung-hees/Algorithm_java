package holiday;

import java.util.Scanner;

public class Main_백준_11654_아스키코드 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//문자->숫자
		int c = sc.next().charAt(0);
		//숫자->문자
		int num = sc.nextInt();
		char ch = (char)num;
		System.out.println(c);
		
		
	}

}
