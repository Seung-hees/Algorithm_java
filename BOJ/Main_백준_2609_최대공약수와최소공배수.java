import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2609_최대공약수와최소공배수 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int n = a*b;

		while (true) {
			if (a > b) {
				a -=b; 
			} else {
				b -= a;
			}
			if (a == 0 || b == 0) {
				break;
			}
		}
		int gcd = a > b ? a : b;
		System.out.println(gcd);// 최대공약수
		System.out.println(n/gcd);// 최소공배수

	}// end of main

}// end of class
