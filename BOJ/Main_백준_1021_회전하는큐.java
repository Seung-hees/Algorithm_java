import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_백준_1021_회전하는큐 {
	public static void main(String[] args) throws IOException {

		Deque<Integer> dq = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 큐의 크기
		int M = Integer.parseInt(st.nextToken()); // 뽑아내려는 수의 개수
		int[] arr = new int[M];
		st = new StringTokenizer(br.readLine(), " ");

		// 배열 삽입
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 입력
		for (int i = 1; i <= N; i++) {
			dq.addLast(i);
		}

		int cnt = 0;

		for (int i = 0; i < M; i++) {
			
			int size = dq.size();

			int idx = 0;
			Iterator<Integer> it = dq.iterator();
			while (it.hasNext()) {
				if (it.next() == arr[i]) {
					break;
				}
				idx++;
			}
			if (idx > size / 2) {
				while (dq.peekFirst() != arr[i]) {
					dq.addFirst(dq.removeLast());
					cnt++;
				}
				// 같아지면
				dq.removeFirst();
			} else {
				while (dq.peekFirst() != arr[i]) {
					dq.addLast(dq.removeFirst());
					cnt++;
				}
				dq.removeFirst();
			}

		}
		System.out.println(cnt);

	}// end of main

}// end of class
