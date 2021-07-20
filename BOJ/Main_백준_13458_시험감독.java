import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// long 형과 음수일 경우
public class Main_백준_13458_시험감독 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());// 시험장의 개수
		int[] arr = new int[N];// 각 시험장에 있는 응시자의 수

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		int B = Integer.parseInt(st.nextToken());// 총 감독관이 가능한 수
		int C = Integer.parseInt(st.nextToken());// 부감독관의 수

		long cnt = 0;// 총감독관의 수
		for (int i = 0; i < N; i++) {
			int n = arr[i];
			n -= B;// 총감독관이 관리하는 수
			cnt++;// 총감독관 +1
			if(n<=0) continue;
			cnt += n / C;// 부감독관 수
			if (n % C != 0) {
				cnt++;
			}

		}
		System.out.println(cnt);

	}// end of main

}// end of class
