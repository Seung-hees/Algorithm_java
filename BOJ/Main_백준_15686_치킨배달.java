import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_����_15686_ġŲ��� {

	static class point {
		int x;
		int y;

		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static int M;
	private static int min = Integer.MAX_VALUE;
	private static int N;
	private static ArrayList<point> chicken;
	private static ArrayList<point> house;
	private static boolean[] open;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());// ���� N*N
		M = Integer.parseInt(st.nextToken());// �����Ű�� ���� ġŲ�� M��

		chicken = new ArrayList<point>();
		house = new ArrayList<point>();

		int n = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				n = Integer.parseInt(st.nextToken());
				if (n == 2) {// ġŲ���� �� ������
					chicken.add(new point(i, j));
				} else if (n == 1) {
					house.add(new point(i, j));
				}
			}
		}

		open = new boolean[chicken.size()];
		// �Է¿Ϸ�

		comb(0, 0);
		// ���� �Ϸ�

		System.out.println(min);
	}// end of main

	private static void comb(int start, int cnt) {
		if (cnt == M) {
			// ���⼭ �񱳸� ���ַ� ��������
			compare(open);
			return;
		}

		for (int i = start; i < chicken.size(); i++) {
			open[i] = true;
			comb(i + 1, cnt + 1);
			open[i] = false;
		}

	}

	private static void compare(boolean[] open) {

		int sum = 0;
		for (int i = 0; i < house.size(); i++) {
			int temp = Integer.MAX_VALUE;

			point s = house.get(i);
			
			for (int j = 0; j < chicken.size(); j++) {
				if (open[j]) {
					point p = chicken.get(j);
					temp = Math.min(temp, cal(s.x, s.y, p.x, p.y));
				}
			}
			sum += temp;
		}
		min = Math.min(min, sum);

	}

	private static int cal(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}
}// end of class
