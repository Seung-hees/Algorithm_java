import java.util.Scanner;

public class Main_정올_1037_오류교정 {	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] arr = new int[N][N];
		int sum = 0;
		int x = 0;
		int y = 0;
		int ok = 0;
		int x_notok = 0;
		int y_notok = 0;
		
		// 배열 만들기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		// 행으로 검사 
		for (int i = 0; i < N; i++) {
			sum = 0;
			for (int j = 0; j < N; j++) {
				sum+=arr[i][j];
			}
			if(sum%2==0) {
				ok++;
			}else {
				x_notok++;
				x = i+1;
				//System.out.println(i);
			}
		}
		
		
		for (int j = 0; j < N; j++) {
			sum = 0;
			for (int i = 0; i < N; i++) {
				sum+=arr[i][j];
			}
			if(sum%2==0) {
				ok++;
			}else {
				y_notok++;
				y = j+1;
			}
		}
		
		
		if(ok == 2*N) {
			System.out.println("OK");
		}else if(ok == (2*N-2)&&x_notok ==1 && y_notok ==1) {
			System.out.println("Change bit ("+x+","+y+")");
		}else {
			System.out.println("Corrupt");
		}
		
		
	}
}
