import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// a가 b의 약수일 경우 : factor
// a가 b의 배수일 경우  : multiple
// a가 둘 다 아닐 경우 : neither
public class Main_백준_5086_배수와약수 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (a == 0 && b == 0) {
				break;
			}
			// 두 수가 같은 경우는 존재하지 않음
			if (a > b) {// a가 배수
				if (a % b == 0) {
					System.out.println("multiple");
				} else {
					System.out.println("neither");
				}
			} else {
				if (b % a == 0) {
					System.out.println("factor");
				} else {
					System.out.println("neither");
				}
			}

		}

	}// end of main

}// end of class
