import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_백준_2606_바이러스 {
	private static boolean[] check;
	private static int[][] graph;
	private static int N;
	private static int sum = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();// 노드의 수
		int M = sc.nextInt();// 간선의 수

		graph = new int[N + 1][N + 1];// graph
		check = new boolean[N + 1];// 방문 여부

		for (int i = 0; i < M ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			graph[a][b] = 1;
			graph[b][a] = 1;
		}

		BFS(1);
		System.out.println(sum-1);//자기자신 제외

	}// end of main

	public static void BFS(int i) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(i);
		check[i] = true;
		while (!q.isEmpty()) {
			int v = q.poll();
			sum++;
			for (int j = 1; j < N + 1; j++) {
				if (graph[v][j] == 1 && !check[j]) {
					q.offer(j);
					check[j] = true;
				}
			}
		}

	}

}// end of class
