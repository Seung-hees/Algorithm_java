import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// long ���� ������ ���
public class Main_����_13458_���谨�� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());// �������� ����
		int[] arr = new int[N];// �� �����忡 �ִ� �������� ��

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		int B = Integer.parseInt(st.nextToken());// �� �������� ������ ��
		int C = Integer.parseInt(st.nextToken());// �ΰ������� ��

		long cnt = 0;// �Ѱ������� ��
		for (int i = 0; i < N; i++) {
			int n = arr[i];
			n -= B;// �Ѱ������� �����ϴ� ��
			cnt++;// �Ѱ����� +1
			if(n<=0) continue;
			cnt += n / C;// �ΰ����� ��
			if (n % C != 0) {
				cnt++;
			}

		}
		System.out.println(cnt);

	}// end of main

}// end of class
