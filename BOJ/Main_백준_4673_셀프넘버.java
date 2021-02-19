package holiday;

import java.util.Arrays;

public class Main_백준_4673_셀프넘버 {
	public static void main(String[] args) {

		boolean[] k = self_number(10000);
		for (int i = 1; i <= 10000; i++) {
			if (k[i] == false) {
				System.out.println(i);
			}
		}

	}// end of main

	public static boolean[] self_number(int n) {
		boolean[] a = new boolean[n + 1];
	
		for (int i = 1; i <=n; i++) {
			int s = i;
			int news = s;
			while(s!=0) {
				news+=s%10;
				s/=10;
			}
			if(news<=n) {
				a[news]=true;
			}
		}
		
		
		return a;

	}

}// end of class
