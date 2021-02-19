package workshop;

import java.util.Scanner;

public class Main_백준_10250_ACM호텔 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();// 테케
		for (int t = 0; t < tc; t++) {// 테케 만큼

			int H = sc.nextInt(); // 호텔의 높이
			int W = sc.nextInt();// 호텔의 방호수 길이

			int N = sc.nextInt(); // 몇 번째 손님.
			int num = 0;
			int[][] arr = new int[H + 1][W + 1];// 0은 쓰지 않음. 무조건 1,1 부터 시작해야함.
			int floor = 0;
			int number = 0;

			for (int j = 1; j < W + 1; j++) {// 호수
				for (int i = 1; i < H + 1; i++) {// 층
					num++;
					if (num == N) {
						floor = i;
						number = j;
						break;
					}
				}
			} // 방탐색 끝
			//System.out.println(floor + " "+number);
			String room ="";
			if (number < 10) {// 호수가 10이하면 앞에 0을 붙여줘야 함.
				room = '0'+Integer.toString(number);
			}else {
				room = Integer.toString(number);
			}
			String F = Integer.toString(floor);
			
			
			System.out.println(F+room);

		} // end of tc

	}// end of main
}// end of class
