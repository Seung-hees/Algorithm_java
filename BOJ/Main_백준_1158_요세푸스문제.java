package workshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//K-1 까지 POP해서 뒤에 넣음.
//그리고 K 를 sb에 삽입.

public class Main_백준_1158_요세푸스문제 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		Queue <Integer> queue = new LinkedList<Integer>();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		//1~N 까지 큐에 삽입
		for (int i = 1; i <= N ; i++) {
			queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			
			// K-1 만큼 POP 해서 뒤에 넣음
			for (int j = 1; j <=K-1; j++) {
				queue.offer(queue.poll());
			}
			sb.append(queue.poll()+", ");
			
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb);
		
		
		
	}// end of main

}// end of class
