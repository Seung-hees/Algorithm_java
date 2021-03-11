import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1152_단어의개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().trim().split(" ");
		int len = 0;
		if (s[0].equals("")) {
			len++;
		}
		
		System.out.println(s.length - len);

	}// end of main

}// end of class
