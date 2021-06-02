import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

//HashMap 사용
//시간 O(nlogn)

public class Main_백준_18870_좌표압축 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		HashMap<Integer, Integer> hm = new HashMap<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int t = 0; t < N; t++) {
			arr[t] = Integer.parseInt(st.nextToken());
		}

		int idx = 0;
		int tnum[] = arr.clone();
		Arrays.sort(arr);// 원래의 배열 정렬
		int s = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			if (s != arr[i]) {// 그 다음 꺼 중복 피하기 위해
				hm.put(arr[i], idx++);
				s = arr[i];
			}
		}

		for (int i = 0; i < N; i++) {
			sb.append(hm.get(tnum[i]) + " ");
		}

		System.out.println(sb.toString());
	}// end of main

}// end of class
