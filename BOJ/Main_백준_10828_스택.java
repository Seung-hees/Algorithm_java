
import java.util.Scanner;
import java.util.Stack;


public class Main_백준_10828_스택 {
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			String op = sc.next();
			switch (op) {
			case "push":
				int n = sc.nextInt();
				stack.push(n);
				break;
			case "pop":
				if (stack.isEmpty()) {
					sb.append(-1+"\n");
				} else {
					sb.append(stack.pop()+"\n");
				}
				break;
			case "size":
				sb.append(stack.size()+"\n");
				break;
			case "empty":
				if (stack.isEmpty()) {
					sb.append(1+"\n");
				} else {
					sb.append(0+"\n");
				}
				break;
			case "top":
				if (stack.isEmpty()) {
					sb.append(-1+"\n");
				} else {
					sb.append(stack.peek()+"\n");
				}
				break;
			}

		}
		System.out.println(sb);

	}// end of main

}// end of class
