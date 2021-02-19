package add;

import java.util.Scanner;

public class Main_백준_1085_직사각형에서탈출 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		
		int min = Math.min(Math.min(x, y),Math.min(w-x, h-y));
		System.out.println(min);
		
	}

}
