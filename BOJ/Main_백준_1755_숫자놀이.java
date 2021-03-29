import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1755_숫자놀이 {
	static class num implements Comparable<num> {
		int n;
		String snum;

		public num(int n, String snum) {
			super();
			this.n = n;
			this.snum = snum;
		}

		@Override
		public int compareTo(num o) {
			return (this.snum).compareTo(o.snum);
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		num[] list = new num[N - M + 1];
		String[] word = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

		int idx = 0;
		for (int i = M; i <= N; i++) {
			int k = i;
			String s = "";
			
			while (true) {
				if (k / 10 == 0) {

					s += word[k];
					list[idx++] = new num(i, s);

					break;
				} else {
					
					int nk = k / 10; 
					s += word[nk] + " ";
					k = i % 10;

				}
			}

		}

		Arrays.sort(list);
		int cnt = 0;
		for (int i = 0; i < list.length; i++) {
			sb.append(list[i].n).append(" ");
			cnt++;
			if(cnt %10 == 0) {
				sb.append("\n");
			}
		}
		System.out.println(sb);

	}// end of main

}// end of class
