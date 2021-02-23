package workshop;

import java.util.Scanner;

public class Main_1652_누울자리를찾아라 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();// 방의 크기
		char[][] arr = new char[N][N];
		sc.nextLine();

		for (int i = 0; i < N; i++) {
			String s = sc.nextLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		// 가로인 경우
		int x = 0;
		//세로인 경우
		int y = 0;
		
		for (int i = 0; i < N; i++) {// 행
			
			//가로
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if(arr[i][j] == '.') {
					cnt++;
				}else {// X
					if(cnt>=2)
						x++;
					cnt=0;
				}
			}
			if(cnt>=2)
				x++;
			
			//세로
			int cnt2 = 0;
			for (int j = 0; j < N; j++) {
				if(arr[j][i] == '.') {
					cnt2++;
				}else {// X
					if(cnt2>=2)
						y++;
					cnt2=0;
				}
			}
			if(cnt2>=2)
				y++;
			
		}

		System.out.print(x + " "+y);

	}

}
