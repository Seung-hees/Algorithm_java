import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2675_문자열반복 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());// tc
		for (int t = 0; t < TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			String s = st.nextToken();

			for (int i = 0; i < s.length(); i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(s.charAt(i));
				}
			}

			System.out.println();

		}

	}// end of main

}// end of class
