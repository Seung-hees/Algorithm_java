import java.io.*;
import java.util.*;

class Solution {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int sum = 0;
			int v = 0;
			for (int i = 0; i < N; i++) {
				int c = sc.nextInt();
				switch (c) {
				case 0:
					break;
				case 1:
					v += sc.nextInt();
					break;
				case 2:
					v -= sc.nextInt();
					break;
				}
				if(v<0) v=0;
				sum += v;
			}
			System.out.println("#" + tc + " " + sum);
		}
		sc.close();

	}

}
