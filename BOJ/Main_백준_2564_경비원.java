import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2564_경비원 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());// 가로
		int M = Integer.parseInt(st.nextToken());// 세로

		int num = Integer.parseInt(br.readLine());// 상점의 개수

		int[] map = new int[1 + num];// 인덱스 0은 동근이의 위치

		for (int i = num; i >= 0; i--) {
			st = new StringTokenizer(br.readLine(), " ");
			int dir = Integer.parseInt(st.nextToken());// 방향 , 북 : 1, 남 : 2, 서 : 3, 동 : 4
			int n = Integer.parseInt(st.nextToken());
			// 시계방향 기준
			switch (dir) {
			case 1: // 북
				map[i] = n;
				break;
			case 2:// 남
				map[i] = N + M + N - n;
				break;
			case 3:// 서
				map[i] = N + M + N + M - n;
				break;
			case 4:// 동
				map[i] = N + n;
				break;
			}

		}

		int sum = 0;
		for (int i = 1; i < num + 1; i++) {
			int value1 = Math.abs(map[0] - map[i]); // 시계방향
			int value2 = 2 *( M + N )- value1;// 반시계 방향
			sum += Math.min(value1, value2);
		}

		System.out.println(sum);

	}// end of main

}// end of class
