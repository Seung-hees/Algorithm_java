import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1541_잃어버린괄호 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// '-'로 분류
		String[] minus = br.readLine().split("-");
		// '+'로 분류한 후 각각의 값들을 더해줌
		for (int i = 0; i < minus.length; i++) {
			String[] plus = minus[i].split("\\+");
			int sum = 0;
			for (int j = 0; j < plus.length; j++) {
				sum += Integer.parseInt(plus[j]);
			}
			minus[i] = Integer.toString(sum);
		}
		//System.out.println(Arrays.toString(minus));
		
		int start = Integer.parseInt(minus[0]);
		for (int i = 1; i < minus.length; i++) {
			start-=Integer.parseInt(minus[i]);
		}
		
		System.out.println(start);

	}// end of main

}// end of class
