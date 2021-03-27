import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_백준_11650_좌표정렬하기 {
	static class point implements Comparable<point> {
		int x;
		int y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(point o) {
			if (this.x == o.x)
				return this.y - o.y;
			return this.x - o.x;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		point[] arr = new point[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i] = new point(x,y);
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i <N; i++) {
			System.out.println(arr[i].x+" "+arr[i].y);
		}
		
		

	}// end of main

}// end of class
