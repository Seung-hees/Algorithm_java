import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_1157_단어공부 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		word = word.toUpperCase();
		int[] arr = new int[26];// 알파벳

		for (int i = 0; i < word.length(); i++) {
			arr[word.charAt(i) - 'A']++;
		}

		int max = 0;
		int idx = 0;
		int check = 0;
		for (int i = 0; i < 26; i++) {
			if (max < arr[i]) {
				max = arr[i];
				idx = i;
			}
		}

		for (int i = 0; i < 26; i++) {
			if (max == arr[i])
				check++;
		}
		if (check == 1) {
			System.out.println((char) (idx + 65));
		} else {
			System.out.println("?");
		}

	}// end of main
}// end of class
