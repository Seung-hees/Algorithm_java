import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 지수법칙 a^(n+m) = a^n * a^m
// 모듈러 성질 (a x b) mod C = (a mod C X b mod C) mod C
// (a * b) % C = (a % C * b % C) % C
public class Main_백준_1629_곱셈 {
	private static long C;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		System.out.println(pow(A, B));

	}// end of main

	// 밑 a , 지수 e
	private static long pow(long a, long b) {

		// 기저조건
		// 지수가 1일 경우 a^1 이므로 a를 그대로 리턴
		if (b == 1) {
			return a % C;
		}

		// 지수의 절반에 해당하는 a^(e/2) 을 구한다.
		long temp = pow(a, b / 2);// 여기서 다 구해져서 결과 반환
		
		/*
		 * 현재 지수가 홀수 였다면
		 * A^(exponent/2) * A^(exponent/2) * A 이므로
		 * A를 한 번 더 곱해주어야 한다.
		 *  
		 */

		if (b % 2 == 1) {
			return (temp * temp % C) * a % C;
		}

		return temp * temp % C;

	}

}// end of class
