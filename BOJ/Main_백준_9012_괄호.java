import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_백준_9012_괄호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());// tc
		for (int i = 0; i < N; i++) {
			boolean check = true;
			Stack<Character> st = new Stack<Character>();
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '(') {
					st.push('(');
				} else if (s.charAt(j) == ')') {
					if (st.size() == 0) {
						check = false;
						break;
					}
					st.pop();
				}
			} // end of for

			if (check && st.size()==0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

	}// end of main
}// end of class
