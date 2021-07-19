import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// �켱������ �ξ� 1,2,3 ������ ���� ������
public class Main_����_2661_�������� {
	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		insert("", 1);

	}// end of main

	private static void insert(String str, int n) {
	
		if (n - 1 == N) {
			System.out.println(str);
			System.exit(0);// �������� 
		}

		
		for (int i = 1; i <=3 ; i++) {
			if (check(str, i)) {
				insert(str+i, n + 1);
			}
		}
	
	}

	private static boolean check(String str, int s) {

		String ns = str + s;
		int size = ns.length();
		for (int i = 1; i <= size / 2; i++) {
			if (ns.substring(size - i, size).equals(ns.substring(size - i - i, size - i))) {
				return false;
			}
		}

		return true;
	}

}// end of class
