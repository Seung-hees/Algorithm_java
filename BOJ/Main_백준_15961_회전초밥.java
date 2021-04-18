import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_15961_회전초밥 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());// 접시의 수
		int d = Integer.parseInt(st.nextToken());// 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken());// 연속해서 먹는 접시의 수
		int e = Integer.parseInt(st.nextToken());// 쿠폰번호

		int[] sushi = new int[N + k - 1];
		int[] check = new int[d + 1];
		int max = 0;

		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < k - 1; i++) {
			sushi[N + i] = sushi[i];
		}
		// System.out.println(Arrays.toString(sushi));
		
		check[e] = 1;
		int cnt = 1;
		
		int left = 0;// sushi 인덱스
		int right = k;
		
		for (int i = 0; i < k; i++) {
			if (check[sushi[i]] == 0) {
				cnt++;
			}
			check[sushi[i]]++;
		}
		

		for (int c = 0; c < N-1 ; c++) {// 횟수
			if(--check[sushi[left]] == 0) {// 삭제
				cnt--;
			}
			left++;
			
			if(check[sushi[right]] == 0) {// 추가
				cnt++;
			}
			check[sushi[right]]++;
			right++;
			
			max = Math.max(max, cnt);
			
		}

		System.out.println(max);

	}// end of main

}// end of class
