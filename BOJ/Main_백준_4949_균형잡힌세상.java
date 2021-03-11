import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_백준_4949_균형잡힌세상 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		while (true) {
			stack.clear();
			String s = br.readLine();
			boolean check = true;
			if (s.equals("."))
				break;
			for (int i = 0; i < s.length(); i++) {
				char op = s.charAt(i);
				if (op == '(') {
					stack.push('(');
				} else if (op == ')') {
					if(!stack.isEmpty() && stack.peek()=='(') {
						stack.pop();
					}else {
						check=false;
						break;
					}

				} else if (op == ']') {
					if(!stack.isEmpty() && stack.peek()=='[') {
						stack.pop();
					}else {
						check=false;
						break;
					}
				} else if (op == '[') {
					stack.push('[');
				}

			}
			if(!check || !stack.isEmpty() ) {
				sb.append("no").append("\n");
			}else {
				sb.append("yes").append("\n");
			}

		}
		System.out.println(sb);

	}// end of main

}// end of class
