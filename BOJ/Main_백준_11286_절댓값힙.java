import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_백준_11286_절댓값힙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) == Math.abs(o2)) {
					return o1 - o2;
				}
				
				return Math.abs(o1) - Math.abs(o2) ;
			}
		});
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			
			int n = Integer.parseInt(br.readLine());
			if(n == 0) {
				if(pq.isEmpty()) {
					sb.append(0).append("\n");
				}else {
					sb.append(pq.poll()).append("\n");
				}
			}else {
				pq.offer(n);
			}
		}
		System.out.println(sb.toString());
		
		
	}// end of main

}// end of class
