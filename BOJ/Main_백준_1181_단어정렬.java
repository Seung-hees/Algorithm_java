import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main_백준_1181_단어정렬 {

	static class word implements Comparable<word> {

		String w;
		int len;

		public word(String word, int len) {
			super();
			this.w = word;
			this.len = len;
		}

		@Override
		public int compareTo(word o) {
			if (this.len == o.len) {
				return this.w.compareTo(o.w);
			}
			return this.len - o.len;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		word[] list = new word[N];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			list[i] = new word(s, s.length());
		}

		Arrays.sort(list);
		System.out.println(list[0].w);
		for (int i = 1; i < N; i++) {
			if ((list[i - 1].w).equals(list[i].w)) {
				continue;
			} else {
				System.out.println(list[i].w);
			}

		}

	}// end of main

}// end of class
