import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_백준_1764_듣보잡 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());// 듣도
		int M = Integer.parseInt(st.nextToken());// 보도

		HashSet<String> hear = new HashSet<>();
		ArrayList<String> result = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			hear.add(br.readLine());
		}

		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if (hear.contains(str)) {
				result.add(str);
			}

		}
		
		Collections.sort(result);
		System.out.println(result.size());
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}

	}// end of main

}// end of class
