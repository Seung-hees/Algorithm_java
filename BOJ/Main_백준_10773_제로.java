import java.util.Scanner;
import java.util.Stack;

public class Main_백준_10773_제로 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> st = new Stack<>();
		
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int n = sc.nextInt();
			if(n==0) {
				st.pop();
			}else {
				st.push(n);
			}
		}
		int sum = 0;
		while(!st.isEmpty()) {
			sum+=st.pop();
		}
		System.out.println(sum);
		
		
	}

}
