package workshop;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Solution_SWEA_1223_계산기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<Character> arr = new ArrayList<Character>();
		Stack<Integer> opstack = new Stack<Integer>();
		for (int t = 1; t <= 10; t++) {

			int N = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			char s;
			int sum = 0;
			int a, b;

			for (int i = 0; i < N; i++) {

				if (str.charAt(i) == '*' || str.charAt(i) == '+') {
					arr.add(str.charAt(i));
				} else {// 숫자라면

					opstack.push(str.charAt(i) - '0');
				}
			}

			while (true) {

				if (arr.size() == 0) {
					sum += opstack.pop();
					break;
				}

				if (arr.get(arr.size() - 1) == '*') {
					a = opstack.pop();
					b = opstack.pop();
					opstack.push(a * b);
					arr.remove(arr.size() - 1);
				} else if (arr.get(arr.size() - 1) == '+') {
					sum += opstack.pop();
					arr.remove(arr.size() - 1);
				}

			}

			System.out.println("#" + t + " " + sum);
		}

	}

}
