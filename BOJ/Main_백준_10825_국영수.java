import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_10825_국영수 {

	static class student implements Comparable<student> {
		String name;
		int korea;
		int english;
		int math;

		public student(String name, int korea, int english, int math) {
			super();
			this.name = name;
			this.korea = korea;
			this.english = english;
			this.math = math;
		}

		@Override
		public int compareTo(student o) {
			if (this.korea == o.korea) {
				if (this.english == o.english) {
					if (this.math == o.math) {
						return this.name.compareTo(o.name);
					}
					return o.math - this.math;
				}

				return this.english - o.english;
			}

			return o.korea - this.korea;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		student[] list = new student[N];
		
		for (int i = 0; i <N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String name = st.nextToken();
			int korea = Integer.parseInt(st.nextToken());
			int english=  Integer.parseInt(st.nextToken());
			int math =  Integer.parseInt(st.nextToken());
			list[i] = new student(name,korea,english,math); 
		}
		
		Arrays.sort(list);
		
		for (int i = 0; i <N; i++) {
			sb.append(list[i].name).append("\n");
		}
		System.out.println(sb.toString());
		
		
		
		
		
		

	}// end of main

}// end of class
