import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_����_12871_���ѹ��ڿ� {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
		String ns = s;
		String nt = t;
		
		if(s.length()!=t.length()) {
			int len = LCM(s.length(),t.length());
			
			while(ns.length()!=len) {
				ns+=s;
			}
			while(nt.length()!=len) {
				nt+=t;
			}	
		}
		
		if(ns.equals(nt)) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
			
		

	}// end of main

	private static int LCM(int a, int b) {
		// �ּҰ���� ���ϱ�
		return (a*b)/gcd(a,b);
	}

	private static int gcd(int a, int b) {
		while(true) {
			if(a>b) {
				a-=b;
			}else {
				b-=a;
			}
			if(a==0 || b==0) {
				break;
			}
		}
		
		return a > b? a : b;
	}

}// end of class
