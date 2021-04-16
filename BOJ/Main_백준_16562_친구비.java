import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_16562_친구비 {
	private static int[] parents,pay;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());// 학생 수
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		// 부모 노드 만들기
		parents = new int[n + 1];
	
		pay  = new int[n+1];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 1; i <= n; i++) {
			pay[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}

		// 서로소 집합 만들기
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			union(v, w);
		}

		int sum = 0;
		for (int i = 1; i <= n; i++) {
			if (parents[i] == i)
				sum+= pay[i];
		}
		System.out.println(sum<=k? sum :"Oh no");

	}// end of main

	private static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if(pay[bRoot] > pay[aRoot]) {
			parents[bRoot] = aRoot;			
		}else {
			parents[aRoot] = bRoot;	
		}

	}

	private static int findSet(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = findSet(parents[a]);
	}
}// end of class
