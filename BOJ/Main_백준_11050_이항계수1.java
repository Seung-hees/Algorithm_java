import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//nCr
public class Main_백준_11050_이항계수1 {
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int m = 1;// 분자
		int n = 1;// 분모
		
		for (int i = N; i > N-K; i--) {
			m*=i;
		}
		for (int i = 1; i <= K; i++) {
			n*=i;
		}
		
		System.out.println(m/n);
		
		
		
	}// end of main

}// end of class
