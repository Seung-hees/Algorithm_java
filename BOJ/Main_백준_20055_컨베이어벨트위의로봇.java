import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문제 이해가 정말 안된 문제 ...
public class Main_백준_20055_컨베이어벨트위의로봇 {

	private static int[] belt;
	private static boolean[] robot;
	private static int N;
	private static int K;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		belt = new int[2*N];
		robot = new boolean[N];
		
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < 2*N; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		while(true) {
			cnt++;
			step1();// 회전
			step2();// 로봇만 이동
			step3();// 올리는 위치에 있는 칸의 내구도 0이 아닐 때 , 위치에 로봇 올림
			if(step4()>=K) {
				break;
			};// 내구도가 0인 칸의 개수가 K개 이상 이상이라면 과정 종료
			
		}
		
		System.out.println(cnt);
		
		

	}// end of main

	private static int step4() {
		int count = 0;
		for (int i = 0; i < 2*N; i++) {
			if(belt[i] == 0) {
				count++;
			}
		}
		return count;
	}

	private static void step3() {
		if(belt[0]!=0 && !robot[0]) {
			robot[0] = true;
			belt[0]--;
		}
		
	}

	private static void step2() {
		if(robot[N-1]) {
			robot[N-1] = false;
		}
		
		for (int i = N-2; i >=0; i--) {
			if(robot[i]) {
				if(!robot[i+1] && belt[i+1]>0) {
					robot[i] = false;
					robot[i+1] = true;
					belt[i+1]--;
				}
			}
		}
		
	}

	private static void step1() {
		// 컨베이너 한칸 씩 복사 (뒤에서 부터)
		int end = belt[2*N-1];
		for (int i = belt.length-2; i >=0 ; i--) {
			belt[i+1] = belt[i];
		}
		belt[0] = end;
		
		// 로봇 한칸씩 복사
		for (int i = N-2; i >=0 ; i--) {
			robot[i+1] = robot[i];
		}
		robot[0] = false;
		
	}

}// end of class
