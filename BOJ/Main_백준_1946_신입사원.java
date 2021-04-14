
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1946_신입사원 {
	
	static class score implements Comparable<score>{
		int document ;
		int interview;
		public score(int document, int interview) {
			super();
			this.document = document;
			this.interview = interview;
		}
		@Override
		public int compareTo(score o) {
			return this.document - o.document;
		}
		@Override
		public String toString() {
			return "score [document=" + document + ", interview=" + interview + "]";
		}
		
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 0; t < TC; t++) {
			int N = Integer.parseInt(br.readLine());// 사원 수
			score[] person = new score[N];			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				int s1 = Integer.parseInt(st.nextToken());
				int s2 = Integer.parseInt(st.nextToken());
				
				person[i] = new score(s1,s2);
				
			}
			
			Arrays.sort(person);
			int pass = 1;
			
			// 윗 지원자보다 서류성적이 낮더라도 면접 순위가 높으면 된다.
			
			int min = person[0].interview;
			for (int i = 1; i < N; i++) {
				if(person[i].interview<= min) {
					min = person[i].interview;
					pass++;
				}
				
			}
			
			System.out.println(pass);

		}// end of tc

	}// end of main

}// end of class
