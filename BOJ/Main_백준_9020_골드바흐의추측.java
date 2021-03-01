package holiday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_9020_골드바흐의추측 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {
			int N = Integer.parseInt(br.readLine());
			int cha = Integer.MAX_VALUE;// 두 수의 차
			int mina = 0;
			int minb = 0;
		
			for (int a = 2; a <= N/2; a++) {// 왼쪽 수 절반까지

				boolean check = true; // a 초기화
				boolean check2 = true;// b 초기화
				// 왼쪽 수 소수 인지 확인
				for (int j = 2; j <=Math.sqrt(a); j++) {
					if(a%j == 0) {// 소수 아님
						check = false;
						break;
					}
				}
				
				int b = N-a;// 오른쪽 수 
				// 오른쪽 수 소수인지 확인
				for (int k = 2; k <=Math.sqrt(b); k++) {
					if(b%k == 0) {//소수가 아님
						check2 = false;
						break;
					}
				}
				
				if(check && check2) {//둘 다 true이면
					if((b-a)<cha) {// 둘의 차가 최소인 a와 b를 찾음
						mina = a;
						minb = b;
					}
				}

			}// 둘의 소수 확인 종료
			System.out.println(mina+" "+minb);

		} // end of tc

	}// end of main
}// end of class
