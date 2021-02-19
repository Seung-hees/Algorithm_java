package holiday;

import java.util.Scanner;

public class Main_백준_2292_벌집 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//

		int room = 1;
		int v = 6; // 방이 커질 때 마다 6씩 공간이 늘어남.
		int multi = 1; // 0부터 시작
		int t = 1;// 전체 1

		while (true) {
			if (N == 1) {
				break;
			}
			if (t >= N) {
				break;
			}
			t += v * multi;// 1번방+6*1 개수 더함.
			room++;// 2번방
			multi++;// multi값 늘림.
			//System.out.println(t);
		}

		System.out.println(room);

	}

}
