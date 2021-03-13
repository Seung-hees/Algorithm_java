import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * dfs와 bfs 어떤 방식으로의 해결방법
 * 범위체크 와 bfs의 방문체크가 헷갈렸던 문제
 *
 */
public class Main_백준_1697_숨바꼭질 {
	private static int K, cnt = 0;
	private static int[] check;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 수빈 출발
		K = sc.nextInt();// 동생 도착
		check = new int[100001];

		bfs(N);

		System.out.println(check[K]-1);

	}// end of main

	public static void bfs(int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(n);
		check[n] = 1;

		while (!q.isEmpty()) {
			int r = q.poll();

			if (r == K) {
				break;
			}

			if (r*2<=100000 && check[2 * r] == 0) {
				q.offer(2 * r);
				check[2 * r] = check[r] + 1;
			}
			if (r-1>=0 && check[r - 1] == 0) {
				q.offer(r - 1);
				check[r - 1] = check[r] + 1;
			}
			if (r+1<=100000 && check[r + 1] == 0) {
				q.offer(r + 1);
				check[r + 1] = check[r] + 1;
			}

		}

	}
}// end of class
