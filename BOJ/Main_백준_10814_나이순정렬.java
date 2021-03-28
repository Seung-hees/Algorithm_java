import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_10814_나이순정렬 {
	static class member implements Comparable<member> {
		int age;
		String name;
		int cnt;

		public member(int age, String name, int cnt) {
			super();
			this.age = age;
			this.name = name;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(member o) {
			if (this.age == o.age) {
				return this.cnt - o.cnt;
			}

			return this.age - o.age;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		member[] list = new member[N];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			list[i] = new member(age, name, cnt);
			cnt++;
		}

		Arrays.sort(list);

		for (int i = 0; i < N; i++) {
			System.out.println(list[i].age + " " + list[i].name);
		}

	}// end of main

}// end of class
