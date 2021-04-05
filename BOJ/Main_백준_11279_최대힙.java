import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_백준_11279_최대힙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
	PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());// 우선 순위 큐는 기본적으로 오름차순 이다. 내림차순으로 바꾸어주어야 함!
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	
	int N = Integer.parseInt(br.readLine());
	
	for (int i = 0; i < N; i++) {
		int n = Integer.parseInt(br.readLine());
		if(n == 0) {
			if(q.isEmpty()) {
				sb.append(0).append("\n");
			}else {
				sb.append(q.poll()).append("\n");
			}
		}else {
			q.offer(n);
		}
				
	}
		
	System.out.println(sb.toString());
		
		
	}// end of main
}// end of class
