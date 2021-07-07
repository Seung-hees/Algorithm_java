import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 큐는 마지막 원소 출력 메서드가 없다.=> Deque 으로 바꾸면 사용이 가능
public class Main_백준_10845_큐 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		//Queue<Integer> q = new LinkedList<Integer>();
		Deque<Integer> q = new LinkedList<Integer>();
		
		int n = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String order = st.nextToken();
			
			switch (order) {
			
			case "push":
				n = Integer.parseInt(st.nextToken());
				q.offer(n);
				break;
			case "pop":
				//sb.append(q.isEmpty() ? -1 :q.poll()).append("\n");
				sb.append(q.isEmpty() ? -1 :q.pollFirst()).append("\n");// pollLast() 도 있음.
				break;
			case "size":
				sb.append(q.size()).append("\n");
				break;
			case "empty":
				if (q.isEmpty()) {
					sb.append(1).append("\n");// 큐가 비어있으면
				} else {
					sb.append(0).append("\n");
				}
				break;
			case "front":
				//sb.append(q.isEmpty() ? -1 : q.peek()).append("\n");
				sb.append(q.isEmpty() ? -1 : q.peekFirst()).append("\n");
				break;
			case "back":
				//sb.append(q.isEmpty() ? -1 : n).append("\n");
				sb.append(q.isEmpty() ? -1 : q.peekLast()).append("\n");
				break;
			}

		}

		System.out.println(sb.toString());

	}// end of main

}// end of class
