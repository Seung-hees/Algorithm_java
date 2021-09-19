import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_����_3190_�� {

	static class Snake {
		int hx;// �Ӹ�
		int hy;// �Ӹ�
		int tx;// ����
		int ty;// ����
		int len; // ����

		public Snake(int hx, int hy, int tx, int ty, int len) {
			this.hx = hx;
			this.hy = hy;
			this.tx = tx;
			this.ty = ty;
			this.len = len;
		}
	}

	private static int[] dx = { -1, 0, 1, 0 };// �������
	private static int[] dy = { 0, 1, 0, -1 };// �������
	private static boolean[][] visited;
	private static int[][] board;
	private static int N;
	private static HashMap<Integer, String> move;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());// map
		board = new int[N + 1][N + 1];// 1~N����
		visited = new boolean[N + 1][N + 1];

		int apple = Integer.parseInt(br.readLine());// ����� ����

		StringTokenizer st = null;
		for (int i = 0; i < apple; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x][y] = 1;// ��� üũ
		}

		move = new HashMap<>();// �� �ʵ� �̵�
		int time = Integer.parseInt(br.readLine());

		for (int i = 0; i < time; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			move.put(Integer.parseInt(st.nextToken()), (String) st.nextElement());
		}

		visited[1][1] = true;
		dfs(new Snake(1, 1, 1, 1, 1), 0, 1);// �� 1,1 �����ϰ� ���� 1, 0��, ���� ������

	}// end of main

	private static void dfs(Snake snake, int time, int dir) {

		if (move.containsKey(time)) {// ���� ������ �� ,����ٲٱ�

		}
		// ������ ����ϱ�

	}

}// end of class