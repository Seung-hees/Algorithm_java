import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> queue = new ArrayDeque<Integer>();
		
		int k = 1;
		for (int i = 0; i < N; i++) {
			queue.offer(k++);
		}
		while(true) {
			if(queue.size()==1) {
				System.out.println(queue.poll());
				break;
			}
			
			queue.poll();
			queue.offer(queue.poll());
			
			
		}
	}

}
