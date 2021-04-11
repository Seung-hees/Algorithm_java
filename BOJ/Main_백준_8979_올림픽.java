import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_백준_8979_올림픽 {

	static class medal implements Comparable<medal> {
		int num;
		int gold;
		int silver;
		int bronze;
		int rank;

		public medal(int num, int gold, int silver, int bronze, int rank) {
			super();
			this.num = num;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
			this.rank = rank;
		}

		@Override
		public int compareTo(medal o) {
			if (this.gold == o.gold) {
				if (this.silver == o.silver) {
					return o.bronze - this.bronze;
				}
				return o.silver - this.silver;
			}
			return o.gold - this.gold;
		}

		@Override
		public String toString() {
			return "medal [num=" + num + ", gold=" + gold + ", silver=" + silver + ", bronze=" + bronze + ", rank="
					+ rank + "]";
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());// 국가 수
		int K = Integer.parseInt(st.nextToken());// 해당 되는 국가

		ArrayList<medal> list = new ArrayList<>();
		medal md = null;

		for (int i = 1; i <= N; i++) {

			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new medal(n, g, s, b, 1));
		}

		Collections.sort(list);

		for (int i = 1; i < list.size(); i++) {
			if(list.get(i-1).gold == list.get(i).gold && list.get(i-1).silver == list.get(i).silver && list.get(i-1).bronze == list.get(i).bronze) {
				list.get(i).rank = list.get(i-1).rank;
			}else {
				list.get(i).rank = i+1;
			}
		}

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).num == K) {
				System.out.println(list.get(i).rank);
			}
		}
	}// end of main

}// end of class
