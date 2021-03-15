import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main_백준_1874_스택수열 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> st = new Stack<>();// 스택생성
		int TC = Integer.parseInt(br.readLine());
		int[] arr = new int[TC];

		// 배열 삽입
		for (int i = TC - 1; i >= 0; i--) {
			arr[i] = Integer.parseInt(br.readLine());
		} 
		
		int n = 1;// 1부터 삽입
		int idx = TC - 1;// 가장 끝
		
		while (n<=TC) {
			
			st.push(n++);
			sb.append('+').append("\n");
			
			while(!st.isEmpty()) {
				if(st.peek() == arr[idx]) {
					st.pop();
					idx--;
					sb.append('-').append("\n");
				}else {
					break;
				}
			}
		}

		if (!st.isEmpty()) {
			System.out.println("NO");
		} else {
			System.out.println(sb);
		}

	}// end of main

}// end of class
