import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 스택이 값이 아닌 인덱스 값을 넣어주면서 관리 인덱스의 배열의 값이 스택의 peek 보다 크면 스택안의 인덱스들을 빼서 인덱스 배열의
 * 값으로 처리, 인덱스를 돌 때마다 스택에 값 삽입
 *
 */
public class Main_백준_17298_오큰수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> st = new Stack<>();

		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int result[] = new int[N];

		StringTokenizer s = new StringTokenizer(br.readLine());

		// 배열 삽입
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(s.nextToken());
		}

		st.push(0);
		for (int i = 1; i < N; i++) {
			while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
				result[st.pop()] = arr[i];
			}
			st.push(i);
		}
		// 모든 인덱스 탐색 종료 후 ,
		// 남은 것 -1
		while (!st.isEmpty()) {
			result[st.pop()] = -1;
		}

		for (int i = 0; i < N; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb);
	}// end of main
}// end of class
