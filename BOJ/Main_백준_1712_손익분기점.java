package holiday;

import java.util.Scanner;

public class Main_백준_1712_손익분기점 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();// 고정비용
		int B = sc.nextInt();// 가변비용
		int C = sc.nextInt(); // 노트북 가격
		int result = -1;

		if(C>B) {
			result = A/(C-B) +1;
		}
		
		System.out.println(result);
	}

}
