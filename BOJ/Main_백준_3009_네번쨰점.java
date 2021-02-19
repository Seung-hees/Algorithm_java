package workshop;

import java.util.Scanner;

public class Main_백준_3009_네번쨰점 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		int x3 = sc.nextInt();
		int y3 = sc.nextInt();

		if (x1 == x2 && x1 != x3)
			sb.append(x3 + " ");
		else if (x1 == x3 && x1 != x2)
			sb.append(x2 + " ");
		else
			sb.append(x1 + " ");

		if (y1 == y2 && y1 != y3)
			sb.append(y3);
		else if (y1 == y3 && y1 != y2)
			sb.append(y2);
		else
			sb.append(y1);

		System.out.println(sb);

	}

}
