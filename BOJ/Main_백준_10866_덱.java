import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_백준_10866_덱 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Deque<Integer> dq = new ArrayDeque<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String or = st.nextToken();
			if (or.equals("push_back")) {
				int num = Integer.parseInt(st.nextToken());
				dq.addLast(num);
			} else if (or.equals("front")) {
				if (dq.isEmpty()) {
					sb.append("-1").append("\n");
				} else {
					sb.append(dq.peekFirst()).append("\n");
				}
			} else if (or.equals("back")) {
				if (dq.isEmpty()) {
					sb.append("-1").append("\n");
				} else {
					sb.append(dq.peekLast()).append("\n");
				}
			} else if (or.equals("size")) {
				sb.append(dq.size()).append("\n");
			} else if (or.equals("empty")) {
				if (dq.isEmpty()) {
					sb.append("1").append("\n");
				} else {
					sb.append("0").append("\n");
				}
			} else if (or.equals("pop_front")) {
				if (dq.isEmpty()) {
					sb.append("-1").append("\n");
				}else {
					sb.append(dq.pollFirst()).append("\n");					
				}
			} else if (or.equals("pop_back")) {
				if (dq.isEmpty()) {
					sb.append("-1").append("\n");
				}else {
					sb.append(dq.pollLast()).append("\n");					
				}
			} else if (or.equals("push_front")) {
				int num = Integer.parseInt(st.nextToken());
				dq.addFirst(num);
			}

		}
		System.out.println(sb.toString());

	}// end of main

}// end of class
