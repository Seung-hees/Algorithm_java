import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_백준_2493_탑 {

	public static void main(String[] args) throws Exception {

		class Tower {
			long index;
			long height;

			Tower(long index, long height) {
				this.index = index;
				this.height = height;
			}
		}
		Stack<Tower> stack = new Stack<Tower>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());// 탑의 개수
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (long i = 1; i <= N; i++) {// 전체 N번

			long height = Long.parseLong(st.nextToken());

			while (true) {
				if (stack.isEmpty()) {
					stack.push(new Tower(i, height));
					System.out.print(0 + " ");
					break;
				}
				if (stack.peek().height <= height) {// 현재가 더 크다면
					stack.pop();
				} else {
					System.out.print(stack.peek().index + " ");
					stack.push(new Tower(i, height));
					break;
				}

			}
		}

	}// end of main

}// end of class
