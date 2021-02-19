package workshop;

import java.util.Scanner;
import java.util.Stack;

public class Solution_SWEA_5432_쇠막대기자르기_이승희 {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		Stack<Character> st = new Stack<Character>();
		
		int TC = sc.nextInt();
		int sum = 0;
		char left,right; // 괄호
		sc.nextLine();
		
		for (int i = 1; i <= TC; i++) {
			sum = 0;
			String bracket = sc.nextLine();
			for (int j = 0; j < bracket.length(); j++) {
				left = bracket.charAt(j);
				if(j == 0) {
					st.push(left);
					continue;
				}
				right = bracket.charAt(j-1);
				if (left == '(') {
					st.push(left);
				}else if(left == ')' && right == '(' ) {// ')'레이저
					st.pop();
					sum +=st.size();
				}else if(left == ')' && right == ')') {
					st.pop();
					sum+=1;// 괄호
				}
			}	
			System.out.println("#"+i+" "+sum);
			
		}
	}
}
