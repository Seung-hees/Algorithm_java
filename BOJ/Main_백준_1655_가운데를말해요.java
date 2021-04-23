import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Main_백준_1655_가운데를말해요 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);// 내림차순
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);// 오름차순
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(i%2 == 0) { // maxHeap 에 숫자추가
				maxHeap.add(num);
			}else { // minHeap 에 숫자 추가
				minHeap.add(num);
			}
			
			if(!maxHeap.isEmpty() && !minHeap.isEmpty()) {// 왼쪽 힙이 오른쪽 힙보다 더 클 경우 둘의 값을 change, 그래야 항상 왼쪽 root 가 중간값! 
				// 외친 수의 개수가 짝수개라면 중간에 있는 두 수 중에서 작은 수를 말해야 한다.
				if(maxHeap.peek()>minHeap.peek()) {// swap
					int tmp = maxHeap.poll();
					maxHeap.add(minHeap.poll());
					minHeap.add(tmp);
				}
			}
			
			sb.append(maxHeap.peek()).append("\n");
			
			
		}
		
		System.out.println(sb.toString());
	}// end of main

}// end of class
