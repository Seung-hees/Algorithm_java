import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 전체 문자열의 길이에서 크로아티아 알파벳과 일치할 경우 해당 길이만큼 빼주는 방식
 */
public class Main_백준_2941_크로아티아알파벳 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String alpha = br.readLine();

		int sum = alpha.length();

		for (int i = 0; i < alpha.length() - 1; i++) {
			char cur = alpha.charAt(i);
			char next = alpha.charAt(i + 1);
			if (cur == 'c' && (next == '=' || next == '-')) {
				sum -= 1;
			} else if (cur == 'd') {
				if (next == '-') {
					sum -= 1;
				} else if (i + 2 < alpha.length()) {
					char nnext = alpha.charAt(i + 2);
					if (next == 'z' && nnext == '=') {
						sum -= 2;
					}
				}
			} else if (cur == 'l' && next == 'j') {
				sum -= 1;
			} else if (cur == 'n' && next == 'j') {
				sum -= 1;
			} else if (cur == 's' && next == '=') {
				sum -= 1;
			} else if ((i - 1 >= 0 && alpha.charAt(i - 1) != 'd' || i == 0) && cur == 'z' && next == '=') {
				sum -= 1;
			}

		}

		System.out.println(sum);
	}// end of main

}// end of class
