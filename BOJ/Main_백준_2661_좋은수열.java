import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 우선순위를 두어 1,2,3 순서로 먼저 들어가도록
public class Main_백준_2661_좋은수열 {
	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		insert("", 1);

	}// end of main

	private static void insert(String str, int n) {
	
		if (n - 1 == N) {
			System.out.println(str);
			System.exit(0);// 강제종료 
		}

		
		for (int i = 1; i <=3 ; i++) {
			if (check(str, i)) {
				insert(str+i, n + 1);
			}
		}
	
	}

	private static boolean check(String str, int s) {

		String ns = str + s;
		int size = ns.length();
		for (int i = 1; i <= size / 2; i++) {
			if (ns.substring(size - i, size).equals(ns.substring(size - i - i, size - i))) {
				return false;
			}
		}

		return true;
	}

}// end of class
