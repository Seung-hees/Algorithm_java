package com.ssafy;

import java.util.Scanner;

public class Main_백준_2908_상수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int newa = 0;
		int newb = 0;
		int k = 10;
		int h = 100;
		
		
		for (int i = 0; i < 3; i++) {
			newa+=a%k*h;
			a/=10;
			h/=10;
		}
		
		k = 10;
		h = 100;
		
		for (int i = 0; i < 3; i++) {
			newb+=b%k*h;
			b/=10;
			h/=10;
		}
		
		System.out.println(Math.max(newa, newb));
		
		
	}
}
