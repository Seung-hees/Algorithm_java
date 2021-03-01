package holiday;

import java.util.Scanner;

public class Main_백준_1929_소수구하기 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		boolean[] num = new boolean[N+1];
		num[0] = true;
		num[1] = true;
		
		for (int i = 2; i <=Math.sqrt(N); i++) {
				if(num[i])
					continue;
			for (int j = i*i; j < N+1; j+=i) {
				num[j] = true;
			}
		}
		
		for (int i = M; i <=N; i++) {
			if(!num[i])
				System.out.println(i);
		}
		
		
		
	}

}
