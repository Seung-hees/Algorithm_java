import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ���� ���ذ� ���� �ȵ� ���� ...
public class Main_����_20055_�����̾Ʈ���Ƿκ� {

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
			step1();// ȸ��
			step2();// �κ��� �̵�
			step3();// �ø��� ��ġ�� �ִ� ĭ�� ������ 0�� �ƴ� �� , ��ġ�� �κ� �ø�
			if(step4()>=K) {
				break;
			};// �������� 0�� ĭ�� ������ K�� �̻� �̻��̶�� ���� ����
			
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
		// �����̳� ��ĭ �� ���� (�ڿ��� ����)
		int end = belt[2*N-1];
		for (int i = belt.length-2; i >=0 ; i--) {
			belt[i+1] = belt[i];
		}
		belt[0] = end;
		
		// �κ� ��ĭ�� ����
		for (int i = N-2; i >=0 ; i--) {
			robot[i+1] = robot[i];
		}
		robot[0] = false;
		
	}

}// end of class
